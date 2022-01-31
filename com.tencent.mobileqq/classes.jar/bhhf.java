import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.qqmini.sdk.log.QMLog;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

public class bhhf
  implements bhgz, bhhc
{
  private float jdField_a_of_type_Float = 0.0F;
  private int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private bhgz jdField_a_of_type_Bhgz;
  private bhhc jdField_a_of_type_Bhhc;
  private Object jdField_a_of_type_JavaLangObject;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float = 0.0F;
  private int jdField_b_of_type_Int = 1;
  private Object jdField_b_of_type_JavaLangObject;
  private String jdField_b_of_type_JavaLangString = "front";
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float = 0.1F;
  private int jdField_c_of_type_Int = 2;
  private Object jdField_c_of_type_JavaLangObject;
  private String jdField_c_of_type_JavaLangString = "vertical";
  private boolean jdField_c_of_type_Boolean = true;
  private int jdField_d_of_type_Int = -1;
  private String jdField_d_of_type_JavaLangString = "high";
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = -1;
  private String jdField_e_of_type_JavaLangString = "";
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private String jdField_f_of_type_JavaLangString = "auto";
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int = 5;
  private String jdField_g_of_type_JavaLangString = "";
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int = 3;
  private String jdField_h_of_type_JavaLangString = "voicecall";
  private boolean jdField_h_of_type_Boolean = true;
  private int jdField_i_of_type_Int = 0;
  private boolean jdField_i_of_type_Boolean = true;
  private int jdField_j_of_type_Int = 368;
  private boolean jdField_j_of_type_Boolean;
  private int jdField_k_of_type_Int = 640;
  private boolean jdField_k_of_type_Boolean;
  private boolean l = true;
  private boolean m;
  private boolean n;
  private boolean o;
  private boolean p;
  private boolean q;
  private boolean r;
  private boolean s;
  
  public bhhf(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidContentContext.getMainLooper());
    this.jdField_b_of_type_JavaLangObject = bhhh.a();
    this.jdField_c_of_type_JavaLangObject = bhhi.a(paramContext);
    bhhi.a(this.jdField_b_of_type_JavaLangObject, this.jdField_c_of_type_JavaLangObject);
    bhhi.d(bhgy.a(this), this.jdField_c_of_type_JavaLangObject);
    bhhi.e(bhgy.a(this), this.jdField_c_of_type_JavaLangObject);
  }
  
  private void a(int paramInt, Object paramObject)
  {
    bhep.a(paramObject, "setVisibility", false, bhep.a(new Class[] { Integer.TYPE }), new Object[] { Integer.valueOf(paramInt) });
  }
  
  private void a(int paramInt, String paramString)
  {
    int i1 = 3;
    QMLog.d("TXLivePusherJSAdapter", "adjustHomeOrientation, angle:" + paramInt + ", orientation:" + paramString);
    if (paramInt == 1) {
      if (paramString.equals("horizontal")) {
        paramInt = i1;
      }
    }
    for (;;)
    {
      QMLog.d("TXLivePusherJSAdapter", "adjustHomeOrientation, homeOrientation:" + paramInt);
      if (paramInt != -2147483648)
      {
        bhhh.a(paramInt, this.jdField_b_of_type_JavaLangObject);
        bhhi.a(this.jdField_b_of_type_JavaLangObject, this.jdField_c_of_type_JavaLangObject);
      }
      return;
      paramInt = 0;
      continue;
      if (paramInt == 3)
      {
        if (paramString.equals("horizontal")) {
          paramInt = 1;
        } else {
          paramInt = 2;
        }
      }
      else if (paramInt == 0)
      {
        if (paramString.equals("horizontal")) {
          paramInt = 0;
        } else {
          paramInt = 1;
        }
      }
      else if (paramInt == 2)
      {
        paramInt = i1;
        if (paramString.equals("horizontal")) {
          paramInt = 2;
        }
      }
      else
      {
        paramInt = -2147483648;
      }
    }
  }
  
  private void a(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      QMLog.d("TXLivePusherJSAdapter", "bitmap recycle " + paramBitmap.toString());
      paramBitmap.recycle();
    }
  }
  
  private void a(Bundle paramBundle, boolean paramBoolean)
  {
    if ((!paramBoolean) && (paramBundle.keySet().size() == 0)) {
      return;
    }
    int i6 = paramBundle.getInt("mode", this.jdField_b_of_type_Int);
    if ((paramBoolean) || (i6 != this.jdField_b_of_type_Int)) {}
    int i4;
    int i5;
    int i1;
    int i2;
    int i3;
    switch (i6)
    {
    default: 
      i4 = this.jdField_d_of_type_Int;
      i5 = this.jdField_e_of_type_Int;
      i1 = paramBundle.getInt("minBitrate", -1);
      i2 = paramBundle.getInt("maxBitrate", -1);
      if (i1 > i2)
      {
        QMLog.e("TXLivePusherJSAdapter", "parseAndApplyParams -> swap min and max bitrate, may be something error. min = " + i1 + " max = " + i2);
        i3 = i2;
      }
      break;
    }
    for (;;)
    {
      if ((i3 != -1) && (i1 != -1))
      {
        i2 = i3;
        if (i3 < 200) {
          i2 = 200;
        }
        i3 = i1;
        if (i1 > 1800) {
          i3 = 1800;
        }
        if (i2 > i3) {}
      }
      for (i1 = i2;; i1 = i4)
      {
        i4 = paramBundle.getInt("aspect", this.jdField_c_of_type_Int);
        i5 = paramBundle.getInt("videoWidth", this.jdField_j_of_type_Int);
        int i7 = paramBundle.getInt("videoHeight", this.jdField_k_of_type_Int);
        String str1 = paramBundle.getString("audioQuality", this.jdField_d_of_type_JavaLangString);
        label290:
        boolean bool1;
        label385:
        label406:
        boolean bool2;
        String str2;
        label538:
        String str3;
        label581:
        float f1;
        label641:
        float f2;
        float f3;
        Object localObject2;
        if (i6 == 6)
        {
          if (i4 == 1)
          {
            bhhh.e(13, this.jdField_b_of_type_JavaLangObject);
            if ((i5 > 0) && (i5 <= 1920) && (i7 > 0) && (i7 <= 1920)) {
              bhhh.a(i5, i7, this.jdField_b_of_type_JavaLangObject);
            }
            if ((i1 != -1) && (i3 != -1) && (i1 <= i3))
            {
              bhhh.b(i1, this.jdField_b_of_type_JavaLangObject);
              bhhh.c(i3, this.jdField_b_of_type_JavaLangObject);
            }
            if (!str1.equalsIgnoreCase("low")) {
              break label1719;
            }
            bhhh.g(16000, this.jdField_b_of_type_JavaLangObject);
          }
        }
        else
        {
          int i8 = paramBundle.getInt("focusMode", this.jdField_f_of_type_Int);
          if (i8 == 0) {
            break label1742;
          }
          bool1 = true;
          bhhh.d(bool1, this.jdField_b_of_type_JavaLangObject);
          bool2 = this.jdField_c_of_type_Boolean;
          bool1 = bool2;
          if (paramBundle.keySet().contains("devicePosition"))
          {
            this.jdField_b_of_type_JavaLangString = paramBundle.getString("devicePosition", this.jdField_b_of_type_JavaLangString);
            bool1 = bool2;
            if (this.jdField_b_of_type_JavaLangString.equalsIgnoreCase("back")) {
              bool1 = false;
            }
            bhhh.c(bool1, this.jdField_b_of_type_JavaLangObject);
          }
          str2 = paramBundle.getString("orientation", this.jdField_c_of_type_JavaLangString);
          if (!str2.equalsIgnoreCase(this.jdField_c_of_type_JavaLangString))
          {
            if (!str2.equalsIgnoreCase("horizontal")) {
              break label1748;
            }
            a(this.jdField_a_of_type_Int, str2);
            bhhi.b(90, this.jdField_c_of_type_JavaLangObject);
          }
          str3 = paramBundle.getString("localMirror", this.jdField_f_of_type_JavaLangString);
          if (!str3.equalsIgnoreCase(this.jdField_f_of_type_JavaLangString))
          {
            if (!str3.equalsIgnoreCase("auto")) {
              break label1779;
            }
            bhhi.c(0, this.jdField_b_of_type_JavaLangObject);
          }
          String str4 = paramBundle.getString("backgroundImage", this.jdField_e_of_type_JavaLangString);
          Object localObject1 = BitmapFactory.decodeFile(str4);
          if (localObject1 != null) {
            bhhh.a((Bitmap)localObject1, this.jdField_b_of_type_JavaLangObject);
          }
          boolean bool3 = paramBundle.getBoolean("backgroundMute", this.jdField_j_of_type_Boolean);
          if (!bool3) {
            break label1823;
          }
          bhhh.d(3, this.jdField_b_of_type_JavaLangObject);
          boolean bool4 = paramBundle.getBoolean("zoom", this.l);
          bhhh.a(bool4, this.jdField_b_of_type_JavaLangObject);
          f1 = paramBundle.getFloat("watermarkLeft", this.jdField_a_of_type_Float);
          f2 = paramBundle.getFloat("watermarkTop", this.jdField_b_of_type_Float);
          f3 = paramBundle.getFloat("watermarkWidth", this.jdField_c_of_type_Float);
          localObject1 = paramBundle.getString("watermarkImage", this.jdField_g_of_type_JavaLangString);
          localObject2 = BitmapFactory.decodeFile((String)localObject1);
          if (localObject2 == null) {
            break label1834;
          }
          bhhh.a((Bitmap)localObject2, f1, f2, f3, this.jdField_b_of_type_JavaLangObject);
          label740:
          boolean bool5 = paramBundle.getBoolean("enableAGC", this.q);
          bhhh.e(bool5, this.jdField_b_of_type_JavaLangObject);
          boolean bool6 = paramBundle.getBoolean("enableANS", this.r);
          bhhh.f(bool6, this.jdField_b_of_type_JavaLangObject);
          boolean bool7 = paramBundle.getBoolean("enableEarMonitor", this.s);
          bhhh.g(bool7, this.jdField_b_of_type_JavaLangObject);
          localObject2 = paramBundle.getString("audioVolumeType", this.jdField_h_of_type_JavaLangString);
          if (!((String)localObject2).equalsIgnoreCase("voicecall")) {
            break label1876;
          }
          bhhh.h(0, this.jdField_b_of_type_JavaLangObject);
          label837:
          boolean bool8 = paramBundle.getBoolean("enableCamera", this.jdField_h_of_type_Boolean);
          if (bool8) {
            break label1898;
          }
          bool2 = true;
          label858:
          bhhh.b(bool2, this.jdField_b_of_type_JavaLangObject);
          i2 = 0;
          if ((i4 != this.jdField_c_of_type_Int) || (i1 != this.jdField_d_of_type_Int) || (i3 != this.jdField_e_of_type_Int) || (i8 != this.jdField_f_of_type_Int) || (bool1 != this.jdField_c_of_type_Boolean) || (bool3 != this.jdField_j_of_type_Boolean) || (bool4 != this.l) || (bool5 != this.q) || (bool6 != this.r) || (bool7 != this.s) || (bool8 != this.jdField_h_of_type_Boolean) || (!str3.equalsIgnoreCase(this.jdField_f_of_type_JavaLangString)) || (i5 != this.jdField_j_of_type_Int) || (i7 != this.jdField_k_of_type_Int) || (f1 != this.jdField_a_of_type_Float) || (f2 != this.jdField_b_of_type_Float) || (f3 != this.jdField_c_of_type_Float) || (!((String)localObject2).equalsIgnoreCase(this.jdField_h_of_type_JavaLangString)) || (!str4.equalsIgnoreCase(this.jdField_e_of_type_JavaLangString)) || (!str2.equalsIgnoreCase(this.jdField_c_of_type_JavaLangString)) || (!str1.equalsIgnoreCase(this.jdField_d_of_type_JavaLangString)) || (!((String)localObject1).equalsIgnoreCase(this.jdField_g_of_type_JavaLangString))) {
            i2 = 1;
          }
          if ((paramBoolean) || (i2 != 0)) {
            bhhi.a(this.jdField_b_of_type_JavaLangObject, this.jdField_c_of_type_JavaLangObject);
          }
          if (bool8 != this.jdField_h_of_type_Boolean)
          {
            if (!bool8) {
              break label1904;
            }
            c();
            a(bool8);
          }
          label1135:
          if (!paramBundle.keySet().contains("enableMic")) {
            break label1930;
          }
          boolean bool9 = paramBundle.getBoolean("enableMic", this.jdField_i_of_type_Boolean);
          if (bool9 != this.jdField_i_of_type_Boolean)
          {
            if (!bool9) {
              break label1911;
            }
            d();
            b(true);
          }
          label1186:
          if ((paramBoolean) || (bool9 != this.jdField_i_of_type_Boolean))
          {
            if (bool9) {
              break label1918;
            }
            bool2 = true;
            label1207:
            bhhi.a(bool2, this.jdField_c_of_type_JavaLangObject);
          }
          this.jdField_i_of_type_Boolean = bool9;
          if (bool9) {
            break label1924;
          }
          bool2 = true;
          label1230:
          this.jdField_g_of_type_Boolean = bool2;
          label1236:
          this.jdField_b_of_type_Int = i6;
          this.jdField_c_of_type_Int = i4;
          this.jdField_f_of_type_Int = i8;
          this.jdField_h_of_type_Boolean = bool8;
          this.q = bool5;
          this.r = bool6;
          this.s = bool7;
          this.jdField_f_of_type_JavaLangString = str3;
          this.jdField_h_of_type_JavaLangString = ((String)localObject2);
          this.jdField_j_of_type_Int = i5;
          this.jdField_k_of_type_Int = i7;
          this.jdField_c_of_type_Boolean = bool1;
          this.jdField_c_of_type_JavaLangString = str2;
          this.jdField_j_of_type_Boolean = bool3;
          this.jdField_e_of_type_JavaLangString = str4;
          this.jdField_d_of_type_Int = i1;
          this.jdField_e_of_type_Int = i3;
          this.jdField_d_of_type_JavaLangString = str1;
          this.l = bool4;
          this.jdField_a_of_type_Float = f1;
          this.jdField_b_of_type_Float = f2;
          this.jdField_c_of_type_Float = f3;
          this.jdField_g_of_type_JavaLangString = ((String)localObject1);
          this.m = paramBundle.getBoolean("needEvent", this.m);
          this.n = paramBundle.getBoolean("needBGMEvent", this.n);
          bool1 = this.p;
          if (!paramBundle.keySet().contains("remoteMirror")) {
            break label1989;
          }
          bool1 = paramBundle.getBoolean("remoteMirror");
        }
        for (;;)
        {
          if (bool1 != this.p) {
            bhhi.b(bool1, this.jdField_c_of_type_JavaLangObject);
          }
          this.p = bool1;
          i1 = paramBundle.getInt("beauty", this.jdField_g_of_type_Int);
          i2 = paramBundle.getInt("whiteness", this.jdField_h_of_type_Int);
          if (i1 != this.jdField_g_of_type_Int) {
            bhhi.a(0, i1, i2, 2, this.jdField_c_of_type_JavaLangObject);
          }
          this.jdField_g_of_type_Int = i1;
          this.jdField_h_of_type_Int = i2;
          i1 = paramBundle.getInt("audioReverbType", this.jdField_i_of_type_Int);
          if (i1 != this.jdField_i_of_type_Int) {
            bhhi.d(i1, this.jdField_c_of_type_JavaLangObject);
          }
          this.jdField_i_of_type_Int = i1;
          bool1 = paramBundle.getBoolean("debug", this.o);
          if ((paramBoolean) || (bool1 != this.o)) {
            bhhi.d(bool1, this.jdField_c_of_type_JavaLangObject);
          }
          this.o = bool1;
          return;
          bhhi.a(1, false, false, this.jdField_c_of_type_JavaLangObject);
          bhhh.f(5, this.jdField_b_of_type_JavaLangObject);
          break;
          bhhi.a(2, true, false, this.jdField_c_of_type_JavaLangObject);
          bhhh.f(5, this.jdField_b_of_type_JavaLangObject);
          break;
          bhhi.a(3, true, false, this.jdField_c_of_type_JavaLangObject);
          bhhh.f(5, this.jdField_b_of_type_JavaLangObject);
          break;
          bhhi.a(4, true, false, this.jdField_c_of_type_JavaLangObject);
          break;
          bhhi.a(5, true, false, this.jdField_c_of_type_JavaLangObject);
          break;
          bhhi.a(6, false, false, this.jdField_c_of_type_JavaLangObject);
          break;
          if (i4 != 2) {
            break label290;
          }
          bhhh.e(0, this.jdField_b_of_type_JavaLangObject);
          break label290;
          label1719:
          if (!str1.equalsIgnoreCase("high")) {
            break label385;
          }
          bhhh.g(48000, this.jdField_b_of_type_JavaLangObject);
          break label385;
          label1742:
          bool1 = false;
          break label406;
          label1748:
          if (!str2.equalsIgnoreCase("vertical")) {
            break label538;
          }
          a(this.jdField_a_of_type_Int, str2);
          bhhi.b(0, this.jdField_c_of_type_JavaLangObject);
          break label538;
          label1779:
          if (str3.equalsIgnoreCase("enable"))
          {
            bhhi.c(1, this.jdField_b_of_type_JavaLangObject);
            break label581;
          }
          if (!str3.equalsIgnoreCase("disable")) {
            break label581;
          }
          bhhi.c(2, this.jdField_b_of_type_JavaLangObject);
          break label581;
          label1823:
          bhhh.d(1, this.jdField_b_of_type_JavaLangObject);
          break label641;
          label1834:
          if ((!bhhi.d(this.jdField_c_of_type_JavaLangObject)) || (!paramBundle.keySet().contains("watermarkImage"))) {
            break label740;
          }
          bhhh.a((Bitmap)localObject2, f1, f2, f3, this.jdField_b_of_type_JavaLangObject);
          break label740;
          label1876:
          if (!((String)localObject2).equalsIgnoreCase("media")) {
            break label837;
          }
          bhhh.h(1, this.jdField_b_of_type_JavaLangObject);
          break label837;
          label1898:
          bool2 = false;
          break label858;
          label1904:
          c();
          break label1135;
          label1911:
          d();
          break label1186;
          label1918:
          bool2 = false;
          break label1207;
          label1924:
          bool2 = false;
          break label1230;
          label1930:
          if (!paramBundle.keySet().contains("muted")) {
            break label1236;
          }
          bool2 = paramBundle.getBoolean("muted", this.jdField_g_of_type_Boolean);
          if ((paramBoolean) || (bool2 != this.jdField_g_of_type_Boolean)) {
            bhhi.a(bool2, this.jdField_c_of_type_JavaLangObject);
          }
          this.jdField_g_of_type_Boolean = bool2;
          break label1236;
          label1989:
          if (paramBundle.keySet().contains("mirror")) {
            bool1 = paramBundle.getBoolean("mirror");
          }
        }
        i3 = i5;
      }
      i3 = i1;
      i1 = i2;
    }
  }
  
  private void a(Boolean paramBoolean, Object paramObject)
  {
    bhep.a(paramObject, "disableLog", false, bhep.a(new Class[] { Boolean.TYPE }), new Object[] { paramBoolean });
  }
  
  private void a(String paramString, Bundle paramBundle)
  {
    if (QMLog.isColorLevel())
    {
      Iterator localIterator = paramBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ((str.equalsIgnoreCase("pushUrl")) || (str.equalsIgnoreCase("orientation")) || (str.equalsIgnoreCase("backgroundImage")) || (str.equalsIgnoreCase("audioQuality")) || (str.equalsIgnoreCase("watermarkImage")) || (str.equalsIgnoreCase("audioVolumeType")) || (str.equalsIgnoreCase("localMirror")) || (str.equalsIgnoreCase("devicePosition"))) {
          paramString = paramString + "\n" + str + " = " + paramBundle.getString(str);
        } else if ((str.equalsIgnoreCase("mode")) || (str.equalsIgnoreCase("focusMode")) || (str.equalsIgnoreCase("beauty")) || (str.equalsIgnoreCase("whiteness")) || (str.equalsIgnoreCase("aspect")) || (str.equalsIgnoreCase("videoWidth")) || (str.equalsIgnoreCase("videoHeight")) || (str.equalsIgnoreCase("audioReverbType")) || (str.equalsIgnoreCase("minBitrate")) || (str.equalsIgnoreCase("maxBitrate"))) {
          paramString = paramString + "\n" + str + " = " + paramBundle.getInt(str);
        } else if ((str.equalsIgnoreCase("hide")) || (str.equalsIgnoreCase("autopush")) || (str.equalsIgnoreCase("muted")) || (str.equalsIgnoreCase("enableCamera")) || (str.equalsIgnoreCase("enableMic")) || (str.equalsIgnoreCase("enableAGC")) || (str.equalsIgnoreCase("enableANS")) || (str.equalsIgnoreCase("enableEarMonitor")) || (str.equalsIgnoreCase("backgroundMute")) || (str.equalsIgnoreCase("zoom")) || (str.equalsIgnoreCase("needEvent")) || (str.equalsIgnoreCase("needBGMEvent")) || (str.equalsIgnoreCase("debug")) || (str.equalsIgnoreCase("mirror")) || (str.equalsIgnoreCase("remoteMirror"))) {
          paramString = paramString + "\n" + str + " = " + paramBundle.getBoolean(str);
        } else if ((str.equalsIgnoreCase("watermarkLeft")) || (str.equalsIgnoreCase("watermarkTop")) || (str.equalsIgnoreCase("watermarkWidth"))) {
          paramString = paramString + "\n" + str + " = " + paramBundle.getFloat(str);
        }
      }
      QMLog.d("TXLivePusherJSAdapter", paramString);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if ((!this.jdField_b_of_type_Boolean) && (paramBoolean))
    {
      a(0, this.jdField_a_of_type_JavaLangObject);
      bhhi.b(this.jdField_a_of_type_JavaLangObject, this.jdField_c_of_type_JavaLangObject);
      this.jdField_b_of_type_Boolean = true;
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      bhhi.f(this.jdField_c_of_type_JavaLangObject);
    }
  }
  
  private void c()
  {
    bhhi.c(true, this.jdField_c_of_type_JavaLangObject);
    this.jdField_b_of_type_Boolean = false;
  }
  
  private void d()
  {
    bhhi.g(this.jdField_c_of_type_JavaLangObject);
  }
  
  public int a(String paramString)
  {
    return bhhi.a(paramString, this.jdField_c_of_type_JavaLangObject);
  }
  
  public bhgp a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return new bhgp(-1, "invalid params");
    }
    a("updateLivePusher", paramBundle);
    if (!this.jdField_a_of_type_Boolean) {
      return new bhgp(-3, "uninited livePusher");
    }
    a(paramBundle, false);
    String str = paramBundle.getString("pushUrl", this.jdField_a_of_type_JavaLangString);
    if ((str != null) && (!str.isEmpty()) && (this.jdField_a_of_type_JavaLangString != null) && (!this.jdField_a_of_type_JavaLangString.equalsIgnoreCase(str)) && (bhhi.d(this.jdField_c_of_type_JavaLangObject)))
    {
      QMLog.d("TXLivePusherJSAdapter", "updateLivePusher: stopPusher");
      c();
      d();
      bhhi.a(this.jdField_c_of_type_JavaLangObject);
    }
    this.jdField_a_of_type_JavaLangString = str;
    bhhi.a(this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_JavaLangObject);
    this.jdField_f_of_type_Boolean = paramBundle.getBoolean("autopush", this.jdField_f_of_type_Boolean);
    if ((this.jdField_f_of_type_Boolean) && (this.jdField_a_of_type_JavaLangString != null) && (!this.jdField_a_of_type_JavaLangString.isEmpty()) && (!bhhi.d(this.jdField_c_of_type_JavaLangObject)))
    {
      QMLog.d("TXLivePusherJSAdapter", "updateLivePusher: startPusher");
      a(this.jdField_h_of_type_Boolean);
      b(this.jdField_i_of_type_Boolean);
      bhhi.a(this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_JavaLangObject);
    }
    return new bhgp();
  }
  
  public bhgp a(Object paramObject, Bundle paramBundle)
  {
    if ((paramObject == null) || (paramBundle == null)) {
      return new bhgp(-1, "invalid params");
    }
    a("InitLivePusher", paramBundle);
    this.jdField_a_of_type_JavaLangObject = paramObject;
    a(Boolean.valueOf(false), this.jdField_a_of_type_JavaLangObject);
    this.jdField_a_of_type_JavaLangString = paramBundle.getString("pushUrl", "");
    bhhi.a(this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_JavaLangObject);
    a(paramBundle, true);
    this.jdField_f_of_type_Boolean = paramBundle.getBoolean("autopush", this.jdField_f_of_type_Boolean);
    if ((this.jdField_f_of_type_Boolean) && (this.jdField_a_of_type_JavaLangString != null) && (!this.jdField_a_of_type_JavaLangString.isEmpty()) && (!bhhi.d(this.jdField_c_of_type_JavaLangObject)))
    {
      QMLog.d("TXLivePusherJSAdapter", "initLivePusher: startPusher");
      a(this.jdField_h_of_type_Boolean);
      b(this.jdField_i_of_type_Boolean);
      bhhi.a(this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_JavaLangObject);
    }
    this.jdField_a_of_type_Boolean = true;
    return new bhgp();
  }
  
  public bhgp a(String paramString, JSONObject paramJSONObject)
  {
    boolean bool1 = true;
    double d1 = 1.0D;
    int i2 = 0;
    int i3 = 0;
    int i1 = 0;
    if (paramString == null) {
      return new bhgp(-1, "invalid params");
    }
    if (!this.jdField_a_of_type_Boolean) {
      return new bhgp(-3, "uninited livePusher");
    }
    String str = "";
    if (paramJSONObject != null) {
      str = paramJSONObject.toString();
    }
    QMLog.d("TXLivePusherJSAdapter", "operateLivePusher: type = " + paramString + " params = " + str);
    if (paramString.equalsIgnoreCase("start")) {
      if ((this.jdField_a_of_type_JavaLangString != null) && (!this.jdField_a_of_type_JavaLangString.isEmpty()) && (!bhhi.d(this.jdField_c_of_type_JavaLangObject)))
      {
        a(this.jdField_h_of_type_Boolean);
        b(this.jdField_i_of_type_Boolean);
        bhhi.a(this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_JavaLangObject);
      }
    }
    for (;;)
    {
      return new bhgp();
      if (paramString.equalsIgnoreCase("stop"))
      {
        this.jdField_k_of_type_Boolean = false;
        bhhi.a(this.jdField_c_of_type_JavaLangObject);
        c();
        d();
        bhhi.a(this.jdField_c_of_type_JavaLangObject);
      }
      else if (paramString.equalsIgnoreCase("pause"))
      {
        if ((this.jdField_k_of_type_Boolean) && (bhhi.d(this.jdField_c_of_type_JavaLangObject))) {
          bhhi.a(false, this.jdField_c_of_type_JavaLangObject);
        }
        bhhi.c(this.jdField_c_of_type_JavaLangObject);
        this.jdField_e_of_type_Boolean = this.jdField_d_of_type_Boolean;
        if (this.jdField_e_of_type_Boolean) {
          a("pauseBGM", null);
        }
      }
      else if (paramString.equalsIgnoreCase("resume"))
      {
        bhhi.b(this.jdField_c_of_type_JavaLangObject);
        if (this.jdField_e_of_type_Boolean) {
          a("resumeBGM", null);
        }
      }
      else if (paramString.equalsIgnoreCase("startPreview"))
      {
        if (bhhi.d(this.jdField_c_of_type_JavaLangObject))
        {
          QMLog.d("TXLivePusherJSAdapter", "do not support startPreview when pushing");
        }
        else
        {
          c();
          a(this.jdField_h_of_type_Boolean);
        }
      }
      else if (paramString.equalsIgnoreCase("stopPreview"))
      {
        if (bhhi.d(this.jdField_c_of_type_JavaLangObject)) {
          QMLog.d("TXLivePusherJSAdapter", "do not support stopPreview when pushing");
        } else {
          c();
        }
      }
      else
      {
        if (paramString.equalsIgnoreCase("switchCamera"))
        {
          if (!this.jdField_c_of_type_Boolean) {}
          for (bool1 = true;; bool1 = false)
          {
            this.jdField_c_of_type_Boolean = bool1;
            bhhh.c(this.jdField_c_of_type_Boolean, this.jdField_b_of_type_JavaLangObject);
            bhhi.d(this.jdField_c_of_type_JavaLangObject);
            break;
          }
        }
        if (paramString.equalsIgnoreCase("toggleTorch"))
        {
          if (bhhi.d(this.jdField_c_of_type_JavaLangObject))
          {
            if (!this.jdField_k_of_type_Boolean)
            {
              boolean bool2 = bhhi.a(bool1, this.jdField_c_of_type_JavaLangObject);
              if (!bool2) {
                break label537;
              }
              label500:
              this.jdField_k_of_type_Boolean = bool1;
              if (!bool2) {
                break label546;
              }
              label511:
              if (!bool2) {
                break label553;
              }
            }
            label537:
            label546:
            label553:
            for (paramString = "Success";; paramString = "Failed")
            {
              return new bhgp(i1, paramString);
              bool1 = false;
              break;
              bool1 = this.jdField_k_of_type_Boolean;
              break label500;
              i1 = -2;
              break label511;
            }
          }
          return new bhgp(-2, "fail");
        }
        if (paramString.equalsIgnoreCase("playBGM"))
        {
          paramString = "";
          if (paramJSONObject != null) {
            paramString = paramJSONObject.optString("BGMFilePath", "");
          }
          QMLog.d("TXLivePusherJSAdapter", "playBGM filePath = " + paramString);
          if ((paramString != null) && (paramString.length() > 0)) {
            bhhi.b(paramString, this.jdField_c_of_type_JavaLangObject);
          } else {
            return new bhgp(-2, "fail");
          }
        }
        else if (paramString.equalsIgnoreCase("stopBGM"))
        {
          bhhi.a(this.jdField_c_of_type_JavaLangObject);
          this.jdField_d_of_type_Boolean = false;
        }
        else if (paramString.equalsIgnoreCase("pauseBGM"))
        {
          bhhi.b(this.jdField_c_of_type_JavaLangObject);
          this.jdField_d_of_type_Boolean = false;
        }
        else if (paramString.equalsIgnoreCase("resumeBGM"))
        {
          bhhi.c(this.jdField_c_of_type_JavaLangObject);
          this.jdField_d_of_type_Boolean = true;
        }
        else
        {
          if (!paramString.equalsIgnoreCase("setBGMPosition")) {
            break;
          }
          if ((this.jdField_d_of_type_Boolean) && (paramJSONObject != null))
          {
            i1 = paramJSONObject.optInt("BGMPosition", -1);
            if (i1 > 0) {
              bhhi.a(i1, this.jdField_c_of_type_JavaLangObject);
            }
          }
        }
      }
    }
    if (paramString.equalsIgnoreCase("setBGMVolume")) {
      if (paramJSONObject == null) {
        break label1011;
      }
    }
    label933:
    label1006:
    label1011:
    for (d1 = paramJSONObject.optDouble("volume", 1.0D);; d1 = 1.0D)
    {
      bhhi.a((float)d1, this.jdField_c_of_type_JavaLangObject);
      break;
      if (paramString.equalsIgnoreCase("setMICVolume"))
      {
        if (paramJSONObject != null) {
          d1 = paramJSONObject.optDouble("volume", 1.0D);
        }
        bhhi.a((float)d1, this.jdField_c_of_type_JavaLangObject);
        break;
      }
      if (paramString.equalsIgnoreCase("sendMessage")) {
        if (paramJSONObject == null) {
          break label1006;
        }
      }
      for (paramString = paramJSONObject.optString("msg");; paramString = null)
      {
        if (paramString != null)
        {
          bool1 = bhhi.a(paramString.getBytes(), this.jdField_c_of_type_JavaLangObject);
          if (bool1)
          {
            i1 = i2;
            if (!bool1) {
              break label933;
            }
          }
          for (paramString = "Success";; paramString = "Failed")
          {
            return new bhgp(i1, paramString);
            i1 = -2;
            break;
          }
        }
        return new bhgp(-2, "fail");
        if (paramString.equalsIgnoreCase("setAudioReverbType"))
        {
          i1 = i3;
          if (paramJSONObject != null) {
            i1 = paramJSONObject.optInt("audioReverbType", 0);
          }
          bhhi.d(i1, this.jdField_c_of_type_JavaLangObject);
          break;
        }
        return new bhgp(-4, "invalid operate command");
      }
    }
  }
  
  public void a()
  {
    this.jdField_d_of_type_Boolean = true;
    if ((this.n) && (this.jdField_a_of_type_Bhhc != null)) {
      this.jdField_a_of_type_Bhhc.a();
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_d_of_type_Boolean = false;
    if ((this.n) && (this.jdField_a_of_type_Bhhc != null)) {
      this.jdField_a_of_type_Bhhc.a(paramInt);
    }
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if ((paramInt == -1307) || (paramInt == -1313)) {
      a("stop", null);
    }
    for (;;)
    {
      if ((this.m) && (this.jdField_a_of_type_Bhgz != null)) {
        this.jdField_a_of_type_Bhgz.a(paramInt, paramBundle);
      }
      paramBundle = paramBundle.getString("EVT_MSG");
      QMLog.d("TXLivePusherJSAdapter", "onPushEvent: event = " + paramInt + " message = " + paramBundle);
      return;
      if ((paramInt == 1003) && (this.jdField_k_of_type_Boolean)) {
        bhhi.a(this.jdField_k_of_type_Boolean, this.jdField_c_of_type_JavaLangObject);
      }
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if ((this.n) && (this.jdField_a_of_type_Bhhc != null)) {
      this.jdField_a_of_type_Bhhc.a(paramLong1, paramLong2);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Bhgz != null) {
      this.jdField_a_of_type_Bhgz.a(paramBundle);
    }
    if (QMLog.isColorLevel())
    {
      paramBundle = String.format("%-16s %-16s %-16s %-12s %-12s %-12s %-12s %-14s %-14s %-14s %-16s %-16s", new Object[] { "CPU:" + paramBundle.getString("CPU_USAGE"), "RES:" + paramBundle.getInt("VIDEO_WIDTH") + "*" + paramBundle.getInt("VIDEO_HEIGHT"), "SPD:" + paramBundle.getInt("NET_SPEED") + "Kbps", "JIT:" + paramBundle.getInt("NET_JITTER"), "FPS:" + paramBundle.getInt("VIDEO_FPS"), "GOP:" + paramBundle.getInt("VIDEO_GOP") + "s", "ARA:" + paramBundle.getInt("AUDIO_BITRATE") + "Kbps", "QUE:" + paramBundle.getInt("AUDIO_CACHE") + " | " + paramBundle.getInt("VIDEO_CACHE") + "," + paramBundle.getInt("V_SUM_CACHE_SIZE") + "," + paramBundle.getInt("V_DEC_CACHE_SIZE") + " | " + paramBundle.getInt("AV_RECV_INTERVAL") + "," + paramBundle.getInt("AV_PLAY_INTERVAL") + "," + String.format("%.1f", new Object[] { Float.valueOf(paramBundle.getFloat("AUDIO_CACHE_THRESHOLD")) }).toString(), "VRA:" + paramBundle.getInt("VIDEO_BITRATE") + "Kbps", "DRP:" + paramBundle.getInt("AUDIO_DROP") + "|" + paramBundle.getInt("VIDEO_DROP"), "SVR:" + paramBundle.getString("SERVER_IP"), "AUDIO:" + paramBundle.getString("AUDIO_PLAY_INFO") });
      QMLog.d("TXLivePusherJSAdapter", "onNetStatus:" + paramBundle);
    }
  }
  
  public void a(bhgz parambhgz)
  {
    this.jdField_a_of_type_Bhgz = parambhgz;
  }
  
  public void a(bhhc parambhhc)
  {
    this.jdField_a_of_type_Bhhc = parambhhc;
  }
  
  public void a(boolean paramBoolean, bhha parambhha)
  {
    if ((this.jdField_c_of_type_JavaLangObject != null) && (bhhi.d(this.jdField_c_of_type_JavaLangObject))) {
      bhhi.c(bhgy.a(new bhhg(this, parambhha, paramBoolean)), this.jdField_c_of_type_JavaLangObject);
    }
  }
  
  public void b()
  {
    bhhi.e(this.jdField_c_of_type_JavaLangObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhhf
 * JD-Core Version:    0.7.0.1
 */