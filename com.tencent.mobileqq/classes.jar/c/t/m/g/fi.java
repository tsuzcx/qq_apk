package c.t.m.g;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentPoi;
import com.tencent.tencentmap.lbssdk.service.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;

public final class fi
  implements Parcelable, TencentLocation
{
  public static final fi a = new fi(-1);
  public fe b;
  public String c;
  private fd d;
  private int e;
  private int f;
  private String g;
  private fb h;
  private final Bundle i = new Bundle();
  private String j = "network";
  private String k = "network";
  private Location l;
  private final long m;
  private long n;
  private int o;
  private int p;
  
  static
  {
    new fi.1();
  }
  
  private fi(int paramInt)
  {
    this.e = paramInt;
    this.m = SystemClock.elapsedRealtime();
    this.n = System.currentTimeMillis();
  }
  
  /* Error */
  private fi(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 47	java/lang/Object:<init>	()V
    //   4: aload_0
    //   5: new 49	android/os/Bundle
    //   8: dup
    //   9: invokespecial 50	android/os/Bundle:<init>	()V
    //   12: putfield 52	c/t/m/g/fi:i	Landroid/os/Bundle;
    //   15: aload_0
    //   16: ldc 54
    //   18: putfield 56	c/t/m/g/fi:j	Ljava/lang/String;
    //   21: aload_0
    //   22: ldc 54
    //   24: putfield 58	c/t/m/g/fi:k	Ljava/lang/String;
    //   27: aload_0
    //   28: invokestatic 66	android/os/SystemClock:elapsedRealtime	()J
    //   31: putfield 68	c/t/m/g/fi:m	J
    //   34: aload_0
    //   35: invokestatic 73	java/lang/System:currentTimeMillis	()J
    //   38: putfield 75	c/t/m/g/fi:n	J
    //   41: new 85	org/json/JSONObject
    //   44: dup
    //   45: aload_1
    //   46: invokespecial 87	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   49: astore_1
    //   50: aload_0
    //   51: new 89	c/t/m/g/fe
    //   54: dup
    //   55: aload_1
    //   56: ldc 91
    //   58: invokevirtual 95	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   61: invokespecial 98	c/t/m/g/fe:<init>	(Lorg/json/JSONObject;)V
    //   64: putfield 100	c/t/m/g/fi:b	Lc/t/m/g/fe;
    //   67: aload_0
    //   68: new 102	c/t/m/g/fd
    //   71: dup
    //   72: aload_1
    //   73: ldc 104
    //   75: invokevirtual 95	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   78: invokespecial 105	c/t/m/g/fd:<init>	(Lorg/json/JSONObject;)V
    //   81: putfield 107	c/t/m/g/fi:d	Lc/t/m/g/fd;
    //   84: aload_0
    //   85: aload_1
    //   86: ldc 109
    //   88: invokevirtual 113	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   91: putfield 115	c/t/m/g/fi:g	Ljava/lang/String;
    //   94: aload_0
    //   95: aload_1
    //   96: ldc 117
    //   98: iconst_0
    //   99: invokevirtual 121	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   102: putfield 123	c/t/m/g/fi:f	I
    //   105: aload_0
    //   106: aload_1
    //   107: ldc 125
    //   109: ldc 127
    //   111: invokevirtual 130	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   114: putfield 132	c/t/m/g/fi:c	Ljava/lang/String;
    //   117: aload_0
    //   118: getfield 132	c/t/m/g/fi:c	Ljava/lang/String;
    //   121: astore_2
    //   122: aload_2
    //   123: ifnull +39 -> 162
    //   126: aload_2
    //   127: ldc 127
    //   129: invokevirtual 138	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   132: ifne +30 -> 162
    //   135: aload_0
    //   136: aload_1
    //   137: ldc 140
    //   139: invokevirtual 144	org/json/JSONObject:optLong	(Ljava/lang/String;)J
    //   142: putfield 75	c/t/m/g/fi:n	J
    //   145: new 146	java/lang/StringBuilder
    //   148: dup
    //   149: ldc 148
    //   151: invokespecial 149	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   154: aload_0
    //   155: getfield 75	c/t/m/g/fi:n	J
    //   158: invokevirtual 153	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: aload_0
    //   163: getfield 123	c/t/m/g/fi:f	I
    //   166: ifle +19 -> 185
    //   169: aload_0
    //   170: ldc 155
    //   172: putfield 58	c/t/m/g/fi:k	Ljava/lang/String;
    //   175: aload_0
    //   176: aload_0
    //   177: getfield 157	c/t/m/g/fi:p	I
    //   180: iconst_1
    //   181: iadd
    //   182: putfield 157	c/t/m/g/fi:p	I
    //   185: aload_1
    //   186: ldc 159
    //   188: invokevirtual 113	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   191: astore_2
    //   192: aload_2
    //   193: invokestatic 165	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   196: ifne +26 -> 222
    //   199: aload_0
    //   200: getfield 52	c/t/m/g/fi:i	Landroid/os/Bundle;
    //   203: ldc 159
    //   205: aload_2
    //   206: ldc 167
    //   208: invokevirtual 171	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   211: iconst_0
    //   212: aaload
    //   213: invokestatic 177	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   216: invokevirtual 181	java/lang/Integer:intValue	()I
    //   219: invokevirtual 185	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   222: aload_1
    //   223: ldc 187
    //   225: invokevirtual 190	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   228: astore_2
    //   229: aload_2
    //   230: ifnull +21 -> 251
    //   233: aload_0
    //   234: new 192	c/t/m/g/fb
    //   237: dup
    //   238: aload_2
    //   239: invokespecial 193	c/t/m/g/fb:<init>	(Lorg/json/JSONObject;)V
    //   242: putfield 195	c/t/m/g/fi:h	Lc/t/m/g/fb;
    //   245: goto +43 -> 288
    //   248: astore_1
    //   249: aload_1
    //   250: athrow
    //   251: aload_1
    //   252: ldc 197
    //   254: invokevirtual 190	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   257: astore_1
    //   258: aload_1
    //   259: ifnull +29 -> 288
    //   262: aload_1
    //   263: ldc 199
    //   265: invokevirtual 203	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   268: ifeq +20 -> 288
    //   271: aload_0
    //   272: new 192	c/t/m/g/fb
    //   275: dup
    //   276: aload_1
    //   277: ldc 199
    //   279: invokevirtual 190	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   282: invokespecial 193	c/t/m/g/fb:<init>	(Lorg/json/JSONObject;)V
    //   285: putfield 195	c/t/m/g/fi:h	Lc/t/m/g/fb;
    //   288: aload_0
    //   289: getfield 195	c/t/m/g/fi:h	Lc/t/m/g/fb;
    //   292: astore_1
    //   293: aload_1
    //   294: ifnull +27 -> 321
    //   297: aload_1
    //   298: getfield 206	c/t/m/g/fb:c	Lc/t/m/g/fg;
    //   301: ifnull +20 -> 321
    //   304: aload_0
    //   305: getfield 52	c/t/m/g/fi:i	Landroid/os/Bundle;
    //   308: aload_0
    //   309: getfield 195	c/t/m/g/fi:h	Lc/t/m/g/fb;
    //   312: getfield 206	c/t/m/g/fb:c	Lc/t/m/g/fg;
    //   315: getfield 210	c/t/m/g/fg:m	Landroid/os/Bundle;
    //   318: invokevirtual 214	android/os/Bundle:putAll	(Landroid/os/Bundle;)V
    //   321: return
    //   322: astore_1
    //   323: aload_1
    //   324: athrow
    //   325: astore_2
    //   326: goto -242 -> 84
    //   329: astore_2
    //   330: goto -108 -> 222
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	333	0	this	fi
    //   0	333	1	paramString	String
    //   121	118	2	localObject	Object
    //   325	1	2	localThrowable	java.lang.Throwable
    //   329	1	2	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   233	245	248	org/json/JSONException
    //   50	67	322	org/json/JSONException
    //   67	84	325	java/lang/Throwable
    //   185	222	329	java/lang/Exception
  }
  
  public static fi a(fi paramfi, int paramInt)
  {
    paramfi.o = paramInt;
    return paramfi;
  }
  
  public static fi a(fi paramfi, et paramet, boolean paramBoolean)
  {
    int i3;
    int i1;
    if ((paramfi != null) && (paramet != null))
    {
      String str = paramfi.g;
      if (str != null)
      {
        int i2 = 0;
        i3 = paramet.f;
        i1 = i2;
        if (str != null)
        {
          i1 = i2;
          if (str.split(",").length > 1) {
            i1 = Integer.parseInt(str.split(",")[1]);
          }
        }
        paramet = paramfi.b;
        if (paramet == null) {
          break label191;
        }
      }
    }
    try
    {
      paramet.d = ((float)e.r(paramet.d, i1, i3));
      label89:
      if (paramBoolean) {
        paramfi.k = "fake";
      }
      if (!paramfi.k.equals("fake"))
      {
        if (paramet.d <= 150.0D)
        {
          paramfi.k = "wifi";
          return paramfi;
        }
        paramfi.k = "cell";
        return paramfi;
        if (paramfi != null)
        {
          if (paramBoolean) {
            paramfi.k = "fake";
          }
          if (!paramfi.k.equals("fake"))
          {
            if (paramfi.getAccuracy() <= 150.0D)
            {
              paramfi.k = "wifi";
              return paramfi;
            }
            paramfi.k = "cell";
          }
        }
      }
      label191:
      return paramfi;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      break label89;
    }
  }
  
  public static void a(fi paramfi)
  {
    if (paramfi != a) {
      return;
    }
    throw new JSONException("location failed");
  }
  
  public final fi a(int paramInt)
  {
    this.p += paramInt;
    return this;
  }
  
  public final void a(Location paramLocation)
  {
    if (this.b != null)
    {
      double d2 = paramLocation.getLatitude();
      double d1 = paramLocation.getLongitude();
      d2 = Math.round(d2 * 1000000.0D);
      Double.isNaN(d2);
      d2 /= 1000000.0D;
      d1 = Math.round(d1 * 1000000.0D);
      Double.isNaN(d1);
      d1 /= 1000000.0D;
      fe localfe = this.b;
      localfe.a = d2;
      localfe.b = d1;
      localfe.c = paramLocation.getAltitude();
      this.b.d = paramLocation.getAccuracy();
    }
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final float getAccuracy()
  {
    fe localfe = this.b;
    if (localfe != null) {
      return localfe.d;
    }
    return 0.0F;
  }
  
  public final String getAddress()
  {
    int i1 = this.e;
    if (i1 == 5) {
      return this.i.getString("addrdesp.name");
    }
    if (i1 == 3)
    {
      localObject = this.h;
      if (localObject != null) {
        return ((fb)localObject).c.l;
      }
      return "";
    }
    Object localObject = this.b;
    if (localObject != null) {
      return ((fe)localObject).f;
    }
    return "";
  }
  
  public final double getAltitude()
  {
    fe localfe = this.b;
    if (localfe != null) {
      return localfe.c;
    }
    return 0.0D;
  }
  
  public final Integer getAreaStat()
  {
    fb localfb = this.h;
    if (localfb != null) {
      return Integer.valueOf(localfb.a);
    }
    return null;
  }
  
  public final float getBearing()
  {
    Location localLocation = this.l;
    if (localLocation == null) {
      return 0.0F;
    }
    return localLocation.getBearing();
  }
  
  public final String getCity()
  {
    fb localfb = this.h;
    if (localfb != null) {
      return localfb.c.f;
    }
    return "";
  }
  
  public final String getCityCode()
  {
    fb localfb = this.h;
    if (localfb != null) {
      return localfb.c.d;
    }
    return "";
  }
  
  public final int getCoordinateType()
  {
    return this.o;
  }
  
  public final double getDirection()
  {
    return this.i.getDouble("direction");
  }
  
  public final String getDistrict()
  {
    fb localfb = this.h;
    if (localfb != null) {
      return localfb.c.g;
    }
    return "";
  }
  
  public final long getElapsedRealtime()
  {
    return this.m;
  }
  
  public final Bundle getExtra()
  {
    return this.i;
  }
  
  public final int getFakeReason()
  {
    return this.p;
  }
  
  public final String getIndoorBuildingFloor()
  {
    fd localfd = this.d;
    if (localfd != null) {
      return localfd.b;
    }
    return "1000";
  }
  
  public final String getIndoorBuildingId()
  {
    fd localfd = this.d;
    if (localfd != null) {
      return localfd.a;
    }
    return null;
  }
  
  public final int getIndoorLocationType()
  {
    fd localfd = this.d;
    if (localfd != null) {
      return localfd.c;
    }
    return -1;
  }
  
  public final double getLatitude()
  {
    fe localfe = this.b;
    if (localfe != null) {
      return localfe.a;
    }
    return 0.0D;
  }
  
  public final double getLongitude()
  {
    fe localfe = this.b;
    if (localfe != null) {
      return localfe.b;
    }
    return 0.0D;
  }
  
  public final String getMotion()
  {
    return this.i.getString("motion");
  }
  
  public final String getName()
  {
    int i1 = this.e;
    if (i1 == 5) {
      return this.i.getString("addrdesp.name");
    }
    if (i1 == 3)
    {
      localObject = this.h;
      if (localObject != null) {
        return ((fb)localObject).c.c;
      }
      return "";
    }
    Object localObject = this.b;
    if (localObject != null) {
      return ((fe)localObject).e;
    }
    return "";
  }
  
  public final String getNation()
  {
    fb localfb = this.h;
    if (localfb != null) {
      return localfb.c.b;
    }
    return "";
  }
  
  public final List<TencentPoi> getPoiList()
  {
    fb localfb = this.h;
    if (localfb != null) {
      return new ArrayList(localfb.b);
    }
    return Collections.emptyList();
  }
  
  public final String getProvider()
  {
    return this.j;
  }
  
  public final String getProvince()
  {
    fb localfb = this.h;
    if (localfb != null) {
      return localfb.c.e;
    }
    return "";
  }
  
  public final String getRawData()
  {
    return this.i.getString("wifi_data");
  }
  
  public final int getRssi()
  {
    Object localObject = this.l;
    if (localObject == null) {
      return 0;
    }
    localObject = ((Location)localObject).getExtras();
    if (localObject == null) {
      return 0;
    }
    return ((Bundle)localObject).getInt("rssi", 0);
  }
  
  public final String getSourceProvider()
  {
    return this.k;
  }
  
  public final float getSpeed()
  {
    Location localLocation = this.l;
    if (localLocation == null) {
      return 0.0F;
    }
    return localLocation.getSpeed();
  }
  
  public final String getStreet()
  {
    fb localfb = this.h;
    if (localfb != null) {
      return localfb.c.j;
    }
    return "";
  }
  
  public final String getStreetNo()
  {
    fb localfb = this.h;
    if (localfb != null) {
      return localfb.c.k;
    }
    return "";
  }
  
  public final long getTime()
  {
    return this.n;
  }
  
  public final String getTown()
  {
    fb localfb = this.h;
    if (localfb != null) {
      return localfb.c.h;
    }
    return "";
  }
  
  public final String getVerifyKey()
  {
    return this.c;
  }
  
  public final String getVillage()
  {
    fb localfb = this.h;
    if (localfb != null) {
      return localfb.c.i;
    }
    return "";
  }
  
  public final int isMockGps()
  {
    return this.f;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("TxLocation{");
    localStringBuilder.append("level=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(",");
    localStringBuilder.append("name=");
    localStringBuilder.append(getName());
    localStringBuilder.append(",");
    localStringBuilder.append("address=");
    localStringBuilder.append(getAddress());
    localStringBuilder.append(",");
    localStringBuilder.append("provider=");
    localStringBuilder.append(getProvider());
    localStringBuilder.append(",");
    localStringBuilder.append("latitude=");
    localStringBuilder.append(getLatitude());
    localStringBuilder.append(",");
    localStringBuilder.append("longitude=");
    localStringBuilder.append(getLongitude());
    localStringBuilder.append(",");
    localStringBuilder.append("altitude=");
    localStringBuilder.append(getAltitude());
    localStringBuilder.append(",");
    localStringBuilder.append("accuracy=");
    localStringBuilder.append(getAccuracy());
    localStringBuilder.append(",");
    localStringBuilder.append("cityCode=");
    localStringBuilder.append(getCityCode());
    localStringBuilder.append(",");
    localStringBuilder.append("areaStat=");
    localStringBuilder.append(getAreaStat());
    localStringBuilder.append(",");
    localStringBuilder.append("nation=");
    localStringBuilder.append(getNation());
    localStringBuilder.append(",");
    localStringBuilder.append("province=");
    localStringBuilder.append(getProvince());
    localStringBuilder.append(",");
    localStringBuilder.append("city=");
    localStringBuilder.append(getCity());
    localStringBuilder.append(",");
    localStringBuilder.append("district=");
    localStringBuilder.append(getDistrict());
    localStringBuilder.append(",");
    localStringBuilder.append("street=");
    localStringBuilder.append(getStreet());
    localStringBuilder.append(",");
    localStringBuilder.append("streetNo=");
    localStringBuilder.append(getStreetNo());
    localStringBuilder.append(",");
    localStringBuilder.append("town=");
    localStringBuilder.append(getTown());
    localStringBuilder.append(",");
    localStringBuilder.append("village=");
    localStringBuilder.append(getVillage());
    localStringBuilder.append(",");
    localStringBuilder.append("bearing=");
    localStringBuilder.append(getBearing());
    localStringBuilder.append(",");
    localStringBuilder.append("time=");
    localStringBuilder.append(getTime());
    localStringBuilder.append(",");
    localStringBuilder.append("poilist=[");
    Iterator localIterator = getPoiList().iterator();
    while (localIterator.hasNext())
    {
      localStringBuilder.append((TencentPoi)localIterator.next());
      localStringBuilder.append(",");
    }
    localStringBuilder.append("]");
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.e);
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
    Object localObject = this.h;
    if (localObject != null) {
      localObject = ((fb)localObject).c.d;
    } else {
      localObject = "";
    }
    paramParcel.writeString((String)localObject);
    paramParcel.writeString(getName());
    paramParcel.writeLong(this.n);
    paramParcel.writeBundle(this.i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.fi
 * JD-Core Version:    0.7.0.1
 */