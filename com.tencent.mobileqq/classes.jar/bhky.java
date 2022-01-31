import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.qqmini.sdk.log.QMLog;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

public class bhky
{
  private float jdField_a_of_type_Float = 1.0F;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private bhkz jdField_a_of_type_Bhkz;
  private bhla jdField_a_of_type_Bhla;
  private bhlb jdField_a_of_type_Bhlb;
  private Object jdField_a_of_type_JavaLangObject;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float = 3.0F;
  private int jdField_b_of_type_Int = 1;
  private Object jdField_b_of_type_JavaLangObject;
  private String jdField_b_of_type_JavaLangString = "vertical";
  private boolean jdField_b_of_type_Boolean;
  private Object jdField_c_of_type_JavaLangObject;
  private String jdField_c_of_type_JavaLangString = "contain";
  private boolean jdField_c_of_type_Boolean;
  private String jdField_d_of_type_JavaLangString = "speaker";
  @Deprecated
  private boolean jdField_d_of_type_Boolean = true;
  private boolean e;
  private boolean f;
  private boolean g = true;
  private boolean h = true;
  private boolean i;
  private boolean j;
  private boolean k;
  private boolean l;
  
  public bhky(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_JavaLangObject = bhiw.a("com.tencent.rtmp.WXLivePlayConfig", null, new Object[0]);
    this.jdField_c_of_type_JavaLangObject = bhiw.a("com.tencent.rtmp.WXLivePlayer", bhiw.a(new Class[] { Context.class }), new Object[] { this.jdField_a_of_type_AndroidContentContext });
    a(Boolean.valueOf(true));
    try
    {
      bhiw.a(this.jdField_c_of_type_JavaLangObject, "setConfig", false, bhiw.a(new Class[] { Class.forName("com.tencent.rtmp.WXLivePlayConfig") }), new Object[] { this.jdField_b_of_type_JavaLangObject });
      paramContext = Class.forName("com.tencent.rtmp.ITXLivePlayListener");
      Object localObject = new bhle(this);
      c(Proxy.newProxyInstance(bhky.class.getClassLoader(), new Class[] { paramContext }, (InvocationHandler)localObject));
      paramContext = Class.forName("com.tencent.rtmp.TXLivePlayer$ITXAudioVolumeEvaluationListener");
      localObject = new bhlc(this);
      e(Proxy.newProxyInstance(bhky.class.getClassLoader(), new Class[] { paramContext }, (InvocationHandler)localObject));
      return;
    }
    catch (ClassNotFoundException paramContext)
    {
      QMLog.e("TXLivePlayerJSAdapter", "bind InnerTXLivePlayListenerImpl failed, e" + paramContext.toString());
    }
  }
  
  private int a(Bundle paramBundle)
  {
    this.jdField_b_of_type_Int = paramBundle.getInt("mode", this.jdField_b_of_type_Int);
    if (this.jdField_b_of_type_Int == 1)
    {
      if (this.jdField_a_of_type_JavaLangString == null) {}
      while ((this.jdField_a_of_type_JavaLangString == null) || ((!this.jdField_a_of_type_JavaLangString.startsWith("http://")) && (!this.jdField_a_of_type_JavaLangString.startsWith("https://"))) || (!this.jdField_a_of_type_JavaLangString.contains(".flv"))) {
        return 0;
      }
      return 1;
    }
    return 5;
  }
  
  private int a(Boolean paramBoolean)
  {
    paramBoolean = bhiw.a(this.jdField_c_of_type_JavaLangObject, "stopPlay", false, bhiw.a(new Class[] { Boolean.TYPE }), new Object[] { paramBoolean });
    if (paramBoolean != null) {
      return ((Integer)paramBoolean).intValue();
    }
    return -1;
  }
  
  private int a(String paramString, int paramInt)
  {
    paramString = bhiw.a(this.jdField_c_of_type_JavaLangObject, "startPlay", false, bhiw.a(new Class[] { String.class, Integer.TYPE }), new Object[] { paramString, Integer.valueOf(paramInt) });
    if (paramString != null) {
      return ((Integer)paramString).intValue();
    }
    return -1;
  }
  
  private void a()
  {
    bhiw.a(this.jdField_c_of_type_JavaLangObject, "resume", false, null, new Object[0]);
  }
  
  private void a(float paramFloat)
  {
    bhiw.a(this.jdField_b_of_type_JavaLangObject, "setCacheTime", false, bhiw.a(new Class[] { Float.TYPE }), new Object[] { Float.valueOf(paramFloat) });
  }
  
  private void a(int paramInt)
  {
    bhiw.a(this.jdField_c_of_type_JavaLangObject, "setRenderRotation", false, bhiw.a(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  private void a(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      QMLog.d("TXLivePlayerJSAdapter", "bitmap recycle " + paramBitmap.toString());
      paramBitmap.recycle();
    }
  }
  
  private void a(Bundle paramBundle, boolean paramBoolean)
  {
    int m = 0;
    boolean bool = this.i;
    String str;
    if (paramBundle.keySet().contains("muteAudio"))
    {
      bool = paramBundle.getBoolean("muteAudio");
      if ((paramBoolean) || (bool != this.i)) {
        f(Boolean.valueOf(bool));
      }
      this.i = bool;
      bool = paramBundle.getBoolean("muteVideo", this.j);
      if ((paramBoolean) || (bool != this.j)) {
        g(Boolean.valueOf(bool));
      }
      this.j = bool;
      str = paramBundle.getString("orientation", this.jdField_b_of_type_JavaLangString);
      if ((paramBoolean) || (!str.equalsIgnoreCase(this.jdField_b_of_type_JavaLangString)))
      {
        if (!str.equalsIgnoreCase("horizontal")) {
          break label489;
        }
        a(270);
      }
      label145:
      this.jdField_b_of_type_JavaLangString = str;
      str = paramBundle.getString("objectFit", this.jdField_c_of_type_JavaLangString);
      if ((paramBoolean) || (!str.equalsIgnoreCase(this.jdField_c_of_type_JavaLangString)))
      {
        if (!str.equalsIgnoreCase("fillCrop")) {
          break label507;
        }
        b(0);
      }
      label196:
      this.jdField_c_of_type_JavaLangString = str;
      if (paramBundle.keySet().contains("soundMode"))
      {
        this.jdField_d_of_type_JavaLangString = paramBundle.getString("soundMode", this.jdField_d_of_type_JavaLangString);
        if (!this.jdField_d_of_type_JavaLangString.equalsIgnoreCase("speaker")) {
          break label525;
        }
        c(0);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Float = paramBundle.getFloat("minCache", this.jdField_a_of_type_Float);
      this.jdField_b_of_type_Float = paramBundle.getFloat("maxCache", this.jdField_b_of_type_Float);
      b(Boolean.valueOf(true));
      a(this.jdField_a_of_type_Float);
      b(this.jdField_a_of_type_Float);
      c(this.jdField_b_of_type_Float);
      this.l = paramBundle.getBoolean("enableRecvMessage", this.l);
      c(Boolean.valueOf(this.l));
      d(this.jdField_b_of_type_JavaLangObject);
      this.e = paramBundle.getBoolean("needEvent", this.e);
      this.g = paramBundle.getBoolean("autoPauseIfNavigate", this.g);
      this.h = paramBundle.getBoolean("autoPauseIfOpenNative", this.h);
      paramBoolean = paramBundle.getBoolean("needAudioVolume", this.k);
      if (paramBoolean != this.k)
      {
        if (paramBoolean) {
          m = 300;
        }
        d(m);
      }
      this.k = paramBoolean;
      paramBoolean = paramBundle.getBoolean("debug", this.f);
      if (paramBoolean != this.f) {
        e(Boolean.valueOf(paramBoolean));
      }
      this.f = paramBoolean;
      return;
      if (!paramBundle.keySet().contains("muted")) {
        break;
      }
      bool = paramBundle.getBoolean("muted");
      break;
      label489:
      if (!str.equalsIgnoreCase("vertical")) {
        break label145;
      }
      a(0);
      break label145;
      label507:
      if (!str.equalsIgnoreCase("contain")) {
        break label196;
      }
      b(1);
      break label196;
      label525:
      if (this.jdField_d_of_type_JavaLangString.equalsIgnoreCase("ear")) {
        c(1);
      }
    }
  }
  
  private void a(Boolean paramBoolean)
  {
    bhiw.a(this.jdField_c_of_type_JavaLangObject, "enableHardwareDecode", false, bhiw.a(new Class[] { Boolean.TYPE }), new Object[] { paramBoolean });
  }
  
  private void a(Object paramObject)
  {
    try
    {
      bhiw.a(this.jdField_c_of_type_JavaLangObject, "setPlayerView", false, bhiw.a(new Class[] { Class.forName("com.tencent.rtmp.ui.TXCloudVideoView") }), new Object[] { paramObject });
      return;
    }
    catch (ClassNotFoundException paramObject)
    {
      paramObject.printStackTrace();
    }
  }
  
  private void a(String paramString, Bundle paramBundle)
  {
    if (QMLog.isColorLevel())
    {
      Iterator localIterator = paramBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ((str.equalsIgnoreCase("playUrl")) || (str.equalsIgnoreCase("orientation")) || (str.equalsIgnoreCase("objectFit")) || (str.equalsIgnoreCase("soundMode"))) {
          paramString = paramString + "\n" + str + " = " + paramBundle.getString(str);
        } else if ((str.equalsIgnoreCase("mode")) || (str.equalsIgnoreCase("playType"))) {
          paramString = paramString + "\n" + str + " = " + paramBundle.getInt(str);
        } else if ((str.equalsIgnoreCase("minCache")) || (str.equalsIgnoreCase("maxCache"))) {
          paramString = paramString + "\n" + str + " = " + paramBundle.getFloat(str);
        } else if ((str.equalsIgnoreCase("hide")) || (str.equalsIgnoreCase("autoplay")) || (str.equalsIgnoreCase("muted")) || (str.equalsIgnoreCase("muteAudio")) || (str.equalsIgnoreCase("muteVideo")) || (str.equalsIgnoreCase("backgroundMute")) || (str.equalsIgnoreCase("needEvent")) || (str.equalsIgnoreCase("needAudioVolume")) || (str.equalsIgnoreCase("enableRecvMessage")) || (str.equalsIgnoreCase("debug"))) {
          paramString = paramString + "\n" + str + " = " + paramBundle.getBoolean(str);
        }
      }
      QMLog.d("TXLivePlayerJSAdapter", paramString);
    }
  }
  
  private boolean a()
  {
    Object localObject = bhiw.a(this.jdField_c_of_type_JavaLangObject, "isPlaying", false, null, new Object[0]);
    if (localObject != null) {
      return ((Boolean)localObject).booleanValue();
    }
    return false;
  }
  
  private void b()
  {
    bhiw.a(this.jdField_c_of_type_JavaLangObject, "pause", false, null, new Object[0]);
  }
  
  private void b(float paramFloat)
  {
    bhiw.a(this.jdField_b_of_type_JavaLangObject, "setMinAutoAdjustCacheTime", false, bhiw.a(new Class[] { Float.TYPE }), new Object[] { Float.valueOf(paramFloat) });
  }
  
  private void b(int paramInt)
  {
    bhiw.a(this.jdField_c_of_type_JavaLangObject, "setRenderMode", false, bhiw.a(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  private void b(Boolean paramBoolean)
  {
    bhiw.a(this.jdField_b_of_type_JavaLangObject, "setAutoAdjustCacheTime", false, bhiw.a(new Class[] { Boolean.TYPE }), new Object[] { paramBoolean });
  }
  
  private void b(Object paramObject)
  {
    try
    {
      bhiw.a(this.jdField_c_of_type_JavaLangObject, "snapshot", false, bhiw.a(new Class[] { Class.forName("com.tencent.rtmp.TXLivePlayer$ITXSnapshotListener") }), new Object[] { paramObject });
      return;
    }
    catch (ClassNotFoundException paramObject)
    {
      paramObject.printStackTrace();
    }
  }
  
  private void c(float paramFloat)
  {
    bhiw.a(this.jdField_b_of_type_JavaLangObject, "setMaxAutoAdjustCacheTime", false, bhiw.a(new Class[] { Float.TYPE }), new Object[] { Float.valueOf(paramFloat) });
  }
  
  private void c(int paramInt)
  {
    bhiw.a(this.jdField_c_of_type_JavaLangObject, "setAudioRoute", false, bhiw.a(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  private void c(Boolean paramBoolean)
  {
    bhiw.a(this.jdField_b_of_type_JavaLangObject, "setEnableMessage", false, bhiw.a(new Class[] { Boolean.TYPE }), new Object[] { paramBoolean });
  }
  
  private void c(Object paramObject)
  {
    try
    {
      bhiw.a(this.jdField_c_of_type_JavaLangObject, "setPlayListener", false, bhiw.a(new Class[] { Class.forName("com.tencent.rtmp.ITXLivePlayListener") }), new Object[] { paramObject });
      return;
    }
    catch (ClassNotFoundException paramObject)
    {
      paramObject.printStackTrace();
    }
  }
  
  private void d(int paramInt)
  {
    bhiw.a(this.jdField_c_of_type_JavaLangObject, "enableAudioVolumeEvaluation", false, bhiw.a(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  private void d(Boolean paramBoolean)
  {
    bhiw.a(this.jdField_a_of_type_JavaLangObject, "disableLog", false, bhiw.a(new Class[] { Boolean.TYPE }), new Object[] { paramBoolean });
  }
  
  private void d(Object paramObject)
  {
    try
    {
      bhiw.a(this.jdField_c_of_type_JavaLangObject, "setConfig", false, bhiw.a(new Class[] { Class.forName("com.tencent.rtmp.WXLivePlayConfig") }), new Object[] { paramObject });
      return;
    }
    catch (ClassNotFoundException paramObject)
    {
      paramObject.printStackTrace();
    }
  }
  
  private void e(Boolean paramBoolean)
  {
    bhiw.a(this.jdField_c_of_type_JavaLangObject, "showDebugLog", false, bhiw.a(new Class[] { Boolean.TYPE }), new Object[] { paramBoolean });
  }
  
  private void e(Object paramObject)
  {
    try
    {
      bhiw.a(this.jdField_c_of_type_JavaLangObject, "setAudioVolumeEvaluationListener", false, bhiw.a(new Class[] { Class.forName("com.tencent.rtmp.TXLivePlayer$ITXAudioVolumeEvaluationListener") }), new Object[] { paramObject });
      return;
    }
    catch (ClassNotFoundException paramObject)
    {
      paramObject.printStackTrace();
    }
  }
  
  private void f(Boolean paramBoolean)
  {
    bhiw.a(this.jdField_c_of_type_JavaLangObject, "muteAudio", false, bhiw.a(new Class[] { Boolean.TYPE }), new Object[] { paramBoolean });
  }
  
  private void g(Boolean paramBoolean)
  {
    bhiw.a(this.jdField_c_of_type_JavaLangObject, "muteVideo", false, bhiw.a(new Class[] { Boolean.TYPE }), new Object[] { paramBoolean });
  }
  
  public Bundle a(JSONObject paramJSONObject)
  {
    int n = 0;
    Bundle localBundle = new Bundle();
    String[] arrayOfString = new String[4];
    arrayOfString[0] = "playUrl";
    arrayOfString[1] = "orientation";
    arrayOfString[2] = "objectFit";
    arrayOfString[3] = "soundMode";
    int i1 = arrayOfString.length;
    int m = 0;
    String str;
    while (m < i1)
    {
      str = arrayOfString[m];
      if (paramJSONObject.has(str)) {
        localBundle.putString(str, paramJSONObject.optString(str));
      }
      m += 1;
    }
    arrayOfString = new String[10];
    arrayOfString[0] = "muted";
    arrayOfString[1] = "muteAudio";
    arrayOfString[2] = "muteVideo";
    arrayOfString[3] = "autoplay";
    arrayOfString[4] = "enableRecvMessage";
    arrayOfString[5] = "needAudioVolume";
    arrayOfString[6] = "needEvent";
    arrayOfString[7] = "autoPauseIfNavigate";
    arrayOfString[8] = "autoPauseIfOpenNative";
    arrayOfString[9] = "debug";
    i1 = arrayOfString.length;
    m = 0;
    while (m < i1)
    {
      str = arrayOfString[m];
      if (paramJSONObject.has(str)) {
        localBundle.putBoolean(str, paramJSONObject.optBoolean(str));
      }
      m += 1;
    }
    arrayOfString = new String[2];
    arrayOfString[0] = "minCache";
    arrayOfString[1] = "maxCache";
    i1 = arrayOfString.length;
    m = 0;
    while (m < i1)
    {
      str = arrayOfString[m];
      if (paramJSONObject.has(str)) {
        localBundle.putFloat(str, (float)paramJSONObject.optDouble(str));
      }
      m += 1;
    }
    arrayOfString = new String[1];
    arrayOfString[0] = "mode";
    i1 = arrayOfString.length;
    m = n;
    while (m < i1)
    {
      str = arrayOfString[m];
      if (paramJSONObject.has(str)) {
        localBundle.putInt(str, paramJSONObject.optInt(str));
      }
      m += 1;
    }
    return localBundle;
  }
  
  public bhkw a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return new bhkw(-1, "invalid params");
    }
    if (!this.jdField_a_of_type_Boolean) {
      return new bhkw(-3, "uninited livePlayer");
    }
    a("updateLivePlayer", paramBundle);
    a(paramBundle, false);
    boolean bool = a();
    String str = paramBundle.getString("playUrl", this.jdField_a_of_type_JavaLangString);
    if ((str != null) && (!str.isEmpty()) && (this.jdField_a_of_type_JavaLangString != null) && (!this.jdField_a_of_type_JavaLangString.equalsIgnoreCase(str)) && (a()))
    {
      QMLog.d("TXLivePlayerJSAdapter", "updateLivePlayer: stopPlay playUrl-old = " + this.jdField_a_of_type_JavaLangString + " playUrl-new = " + str);
      a(Boolean.valueOf(true));
    }
    this.jdField_a_of_type_JavaLangString = str;
    int m = a(paramBundle);
    if ((m != this.jdField_a_of_type_Int) && (a()))
    {
      QMLog.d("TXLivePlayerJSAdapter", "updateLivePlayer: stopPlay  playType-old = " + this.jdField_a_of_type_Int + " playType-new = " + m);
      a(Boolean.valueOf(true));
    }
    this.jdField_a_of_type_Int = m;
    this.jdField_b_of_type_Boolean = paramBundle.getBoolean("autoplay", this.jdField_b_of_type_Boolean);
    if (((this.jdField_b_of_type_Boolean) || (bool)) && (this.jdField_a_of_type_JavaLangString != null) && (!this.jdField_a_of_type_JavaLangString.isEmpty()) && (!a()))
    {
      QMLog.d("TXLivePlayerJSAdapter", "updateLivePlayer: startPlay");
      a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    }
    return new bhkw();
  }
  
  public bhkw a(Object paramObject, Bundle paramBundle)
  {
    if ((paramObject == null) || (paramBundle == null)) {
      return new bhkw(-1, "invalid params");
    }
    a("initLivePlayer", paramBundle);
    this.jdField_a_of_type_JavaLangObject = paramObject;
    d(Boolean.valueOf(false));
    a(paramObject);
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("playUrl", this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Int = a(paramBundle);
    a(paramBundle, true);
    this.jdField_b_of_type_Boolean = paramBundle.getBoolean("autoplay", this.jdField_b_of_type_Boolean);
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_JavaLangString != null) && (!this.jdField_a_of_type_JavaLangString.isEmpty()))
    {
      QMLog.d("TXLivePlayerJSAdapter", "initLivePlayer: startPlay");
      a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_Boolean = true;
    return new bhkw();
  }
  
  public bhkw a(Object paramObject, JSONObject paramJSONObject)
  {
    if (QMLog.isColorLevel()) {
      QMLog.d("TXLivePlayerJSAdapter", "initLivePlayer: params = " + paramJSONObject.toString());
    }
    return a(paramObject, a(paramJSONObject));
  }
  
  public bhkw a(String paramString, JSONObject paramJSONObject)
  {
    if (paramString == null) {
      return new bhkw(-1, "invalid params");
    }
    String str = "";
    if (paramJSONObject != null) {
      str = paramJSONObject.toString();
    }
    QMLog.d("TXLivePlayerJSAdapter", "operateLivePlayer: type = " + paramString + " params = " + str);
    if (!this.jdField_a_of_type_Boolean) {
      return new bhkw(-3, "uninited livePlayer");
    }
    if (paramString.equalsIgnoreCase("play")) {
      a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    }
    for (;;)
    {
      return new bhkw();
      if (paramString.equalsIgnoreCase("stop"))
      {
        a(Boolean.valueOf(true));
      }
      else if (paramString.equalsIgnoreCase("pause"))
      {
        b();
      }
      else
      {
        if (!paramString.equalsIgnoreCase("resume")) {
          break;
        }
        a();
      }
    }
    if (paramString.equalsIgnoreCase("mute"))
    {
      if (!this.jdField_c_of_type_Boolean) {}
      for (boolean bool = true;; bool = false)
      {
        this.jdField_c_of_type_Boolean = bool;
        f(Boolean.valueOf(this.jdField_c_of_type_Boolean));
        break;
      }
    }
    return new bhkw(-4, "invalid operate command");
  }
  
  public bhkw a(JSONObject paramJSONObject)
  {
    if (QMLog.isColorLevel()) {
      QMLog.d("TXLivePlayerJSAdapter", "updateLivePlayer: params = " + paramJSONObject.toString());
    }
    return a(a(paramJSONObject));
  }
  
  public void a(bhkz parambhkz)
  {
    this.jdField_a_of_type_Bhkz = parambhkz;
  }
  
  public void a(bhla parambhla)
  {
    this.jdField_a_of_type_Bhla = parambhla;
  }
  
  public void a(bhlb parambhlb)
  {
    this.jdField_a_of_type_Bhlb = parambhlb;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_c_of_type_JavaLangObject != null) {}
    try
    {
      Class localClass = Class.forName("com.tencent.rtmp.TXLivePlayer$ITXSnapshotListener");
      bhld localbhld = new bhld(this);
      localbhld.a(paramBoolean);
      b(Proxy.newProxyInstance(bhky.class.getClassLoader(), new Class[] { localClass }, localbhld));
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      localClassNotFoundException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhky
 * JD-Core Version:    0.7.0.1
 */