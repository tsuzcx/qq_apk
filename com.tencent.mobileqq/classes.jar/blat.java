import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import dov.com.qq.im.ae.mode.AECaptureMode;
import java.util.HashMap;
import java.util.Map;

public class blat
{
  public static final blat A = new blat("circleGuidePicker", 28);
  public static final blat B = new blat("qudongTakeFacePhoto", 1001, false);
  public static final blat C = new blat("web", 1002, false);
  public static final blat a;
  private static final blat[] jdField_a_of_type_ArrayOfBlat = { b, c, e, r, q, s, g, i, k, l, m, n, o, u, t, w, B, C, v, x, z };
  public static final blat b;
  public static final blat c;
  public static final blat d;
  public static final blat e;
  public static final blat f;
  public static final blat g;
  public static final blat h;
  public static final blat i;
  public static final blat j;
  public static final blat k;
  public static final blat l;
  public static final blat m;
  public static final blat n;
  public static final blat o;
  public static final blat p;
  public static final blat q;
  public static final blat r;
  public static final blat s;
  public static final blat t;
  public static final blat u;
  public static final blat v;
  public static final blat w;
  public static final blat x;
  public static final blat y;
  public static final blat z;
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_Blat = new blat("", -1);
    b = new blat("h5", 0);
    c = new blat("mainCamera", 1);
    d = new blat("", 2);
    e = new blat("aioMainCamera", 3);
    f = new blat("", 4);
    g = new blat("qzoneCamera", 5);
    h = new blat("", 6);
    i = new blat("aioGifCamera", 7);
    j = new blat("", 8);
    k = new blat("aioGroupSignin", 9);
    l = new blat("qzoneSignin", 10);
    m = new blat("qzoneBanner", 11);
    n = new blat("qzoneTail", 12);
    o = new blat("qzoneMoodList", 13);
    p = new blat("", 14);
    q = new blat("qzoneFriendPlus", 15);
    r = new blat("qzoneFriendState", 16);
    s = new blat("qzoneSlideCamera", 17);
    t = new blat("aioChats", 18);
    u = new blat("massSendBless", 19);
    v = new blat("qzonePublishFrame", 20);
    w = new blat("aioGifCameraTail", 23);
    x = new blat("circleCamera", 25);
    y = new blat("circlePickCamera", 26);
    z = new blat("circleGuideCamera", 27);
  }
  
  private blat(String paramString, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = true;
  }
  
  private blat(String paramString, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static int a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return jdField_a_of_type_Blat.a();
    }
    return paramIntent.getIntExtra("VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Blat.a());
  }
  
  public static int a(bkpl parambkpl)
  {
    int i2 = 200;
    int i1 = i2;
    if (parambkpl != null)
    {
      i1 = i2;
      if (parambkpl.a() != null)
      {
        i1 = i2;
        if (parambkpl.a().getIntent() != null) {
          i1 = parambkpl.a().getIntent().getIntExtra("AECAMERA_MODE", 200);
        }
      }
    }
    return i1;
  }
  
  public static int a(String paramString)
  {
    int i2 = 200;
    HashMap localHashMap = new HashMap(4);
    localHashMap.put("camera", Integer.valueOf(200));
    localHashMap.put("all", Integer.valueOf(201));
    localHashMap.put("gif", Integer.valueOf(202));
    localHashMap.put("singlegif", Integer.valueOf(203));
    localHashMap.put("cameraAndPlay", Integer.valueOf(204));
    localHashMap.put("cameraAndGif", Integer.valueOf(205));
    localHashMap.put("play", Integer.valueOf(206));
    localHashMap.put("playAndGif", Integer.valueOf(207));
    int i1 = i2;
    if (paramString != null)
    {
      i1 = i2;
      if (localHashMap.containsKey(paramString))
      {
        i1 = i2;
        if (localHashMap.get(paramString) != null) {
          i1 = ((Integer)localHashMap.get(paramString)).intValue();
        }
      }
    }
    return i1;
  }
  
  public static blat a(int paramInt)
  {
    blat[] arrayOfblat = jdField_a_of_type_ArrayOfBlat;
    int i2 = arrayOfblat.length;
    int i1 = 0;
    while (i1 < i2)
    {
      blat localblat = arrayOfblat[i1];
      if (paramInt == localblat.a()) {
        return localblat;
      }
      i1 += 1;
    }
    return jdField_a_of_type_Blat;
  }
  
  public static blat a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return jdField_a_of_type_Blat;
    }
    blat[] arrayOfblat = jdField_a_of_type_ArrayOfBlat;
    int i2 = arrayOfblat.length;
    int i1 = 0;
    if (i1 < i2)
    {
      blat localblat = arrayOfblat[i1];
      if (TextUtils.isEmpty(localblat.a())) {}
      while (!paramString.equals(localblat.a()))
      {
        i1 += 1;
        break;
      }
      return localblat;
    }
    return jdField_a_of_type_Blat;
  }
  
  @NonNull
  public static String a(@Nullable String paramString)
  {
    if ("camera".equals(paramString)) {
      return String.valueOf(AECaptureMode.NORMAL.name);
    }
    if ("play".equals(paramString)) {
      return String.valueOf(AECaptureMode.PLAY.name);
    }
    if ("gif".equals(paramString)) {
      return String.valueOf(AECaptureMode.GIF.name);
    }
    return String.valueOf(AECaptureMode.NORMAL.name);
  }
  
  public static boolean a(Activity paramActivity)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramActivity != null)
    {
      bool1 = bool2;
      if (paramActivity.getIntent() != null)
      {
        int i1 = paramActivity.getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Blat.a());
        if (i1 != C.a())
        {
          bool1 = bool2;
          if (i1 != B.a()) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(Intent paramIntent)
  {
    boolean bool = false;
    if ((paramIntent == null) || (paramIntent.getIntExtra("VIDEO_STORY_JUMP_TO_TYPE", 0) == 0)) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean a(Intent paramIntent, int paramInt)
  {
    return (paramInt == 14) && (!a(paramIntent)) && (!b(paramIntent));
  }
  
  public static int b(Intent paramIntent)
  {
    if (paramIntent == null) {
      return 0;
    }
    return paramIntent.getIntExtra("VIDEO_STORY_JUMP_TO_TYPE", 0);
  }
  
  public static boolean b(int paramInt)
  {
    return paramInt == t.a();
  }
  
  public static boolean b(Activity paramActivity)
  {
    if (paramActivity == null) {}
    do
    {
      return false;
      paramActivity = paramActivity.getIntent();
    } while (paramActivity == null);
    return d(paramActivity.getIntExtra("VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Blat.a()));
  }
  
  public static boolean b(Intent paramIntent)
  {
    return (paramIntent == null) || (paramIntent.getIntExtra("VIDEO_STORY_MEDIA_TYPE", 100) == 100);
  }
  
  public static int c(Intent paramIntent)
  {
    if (paramIntent == null) {
      return 100;
    }
    return paramIntent.getIntExtra("VIDEO_STORY_MEDIA_TYPE", 100);
  }
  
  public static boolean c(int paramInt)
  {
    return n.a() == paramInt;
  }
  
  public static boolean c(Activity paramActivity)
  {
    if (paramActivity == null) {}
    do
    {
      return false;
      paramActivity = paramActivity.getIntent();
    } while (paramActivity == null);
    if (paramActivity.hasExtra("ORIGIN_VIDEO_STORY_FROM_TYPE")) {}
    for (int i1 = paramActivity.getIntExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Blat.a());; i1 = paramActivity.getIntExtra("VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Blat.a())) {
      return f(i1);
    }
  }
  
  public static boolean c(Intent paramIntent)
  {
    return (m(paramIntent)) || (n(paramIntent)) || (o(paramIntent));
  }
  
  public static boolean d(int paramInt)
  {
    return (paramInt == g.a()) || (paramInt == o.a()) || (paramInt == r.a()) || (paramInt == v.a());
  }
  
  public static boolean d(Activity paramActivity)
  {
    if (paramActivity == null) {}
    do
    {
      return false;
      paramActivity = paramActivity.getIntent();
    } while (paramActivity == null);
    int i1;
    if (paramActivity.hasExtra("ORIGIN_VIDEO_STORY_FROM_TYPE"))
    {
      i1 = paramActivity.getIntExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Blat.a());
      if (n.a() != i1) {
        break label69;
      }
    }
    label69:
    for (boolean bool = true;; bool = false)
    {
      return bool;
      i1 = paramActivity.getIntExtra("VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Blat.a());
      break;
    }
  }
  
  public static boolean d(Intent paramIntent)
  {
    return (paramIntent != null) && (a(paramIntent) == n.a());
  }
  
  public static boolean e(int paramInt)
  {
    return paramInt == c.a();
  }
  
  public static boolean e(Intent paramIntent)
  {
    int i1 = a(paramIntent);
    return (i1 == k.a()) || (i1 == l.a());
  }
  
  public static boolean f(int paramInt)
  {
    return (paramInt == g.a()) || (paramInt == o.a()) || (paramInt == r.a()) || (paramInt == v.a());
  }
  
  public static boolean f(Intent paramIntent)
  {
    return (paramIntent != null) && (a(paramIntent) == e.a());
  }
  
  public static boolean g(int paramInt)
  {
    return e.a() == paramInt;
  }
  
  public static boolean g(Intent paramIntent)
  {
    return (paramIntent != null) && (a(paramIntent) == B.a());
  }
  
  public static boolean h(int paramInt)
  {
    return (paramInt == x.a()) || (i(paramInt));
  }
  
  public static boolean h(Intent paramIntent)
  {
    return (paramIntent != null) && (a(paramIntent) == C.a());
  }
  
  public static boolean i(int paramInt)
  {
    return (paramInt == A.a()) || (paramInt == z.a());
  }
  
  public static boolean i(Intent paramIntent)
  {
    return (paramIntent != null) && ((a(paramIntent) == x.a()) || (j(paramIntent)));
  }
  
  public static boolean j(int paramInt)
  {
    return (paramInt != e.a()) && (paramInt != i.a()) && (paramInt != p.a()) && (paramInt != w.a()) && (paramInt != x.a()) && (paramInt != B.a()) && (paramInt != C.a());
  }
  
  public static boolean j(Intent paramIntent)
  {
    return (paramIntent != null) && ((a(paramIntent) == z.a()) || (a(paramIntent) == A.a()));
  }
  
  private static boolean k(Intent paramIntent)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramIntent != null)
    {
      bool1 = bool2;
      if (paramIntent.getIntExtra("VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Blat.a()) == t.a()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static boolean l(Intent paramIntent)
  {
    return (paramIntent != null) && (paramIntent.getIntExtra("VIDEO_STORY_MEDIA_TYPE", 100) == 101);
  }
  
  private static boolean m(Intent paramIntent)
  {
    return (d(paramIntent)) && (l(paramIntent));
  }
  
  private static boolean n(Intent paramIntent)
  {
    return (k(paramIntent)) && (l(paramIntent));
  }
  
  private static boolean o(Intent paramIntent)
  {
    return (e(paramIntent)) && (l(paramIntent));
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(int paramInt)
  {
    return this.jdField_a_of_type_Int == paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blat
 * JD-Core Version:    0.7.0.1
 */