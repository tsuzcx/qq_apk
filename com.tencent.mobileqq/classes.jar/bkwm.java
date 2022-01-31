import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import dov.com.qq.im.ae.mode.AECaptureMode;
import java.util.HashMap;
import java.util.Map;

public class bkwm
{
  public static final bkwm A = new bkwm("web", 1002, false);
  public static final bkwm a;
  private static final bkwm[] jdField_a_of_type_ArrayOfBkwm = { b, c, e, r, q, s, g, i, k, l, m, n, o, u, t, w, z, A, v, x };
  public static final bkwm b;
  public static final bkwm c;
  public static final bkwm d;
  public static final bkwm e;
  public static final bkwm f;
  public static final bkwm g;
  public static final bkwm h;
  public static final bkwm i;
  public static final bkwm j;
  public static final bkwm k;
  public static final bkwm l;
  public static final bkwm m;
  public static final bkwm n;
  public static final bkwm o;
  public static final bkwm p;
  public static final bkwm q;
  public static final bkwm r;
  public static final bkwm s;
  public static final bkwm t;
  public static final bkwm u;
  public static final bkwm v;
  public static final bkwm w;
  public static final bkwm x;
  public static final bkwm y;
  public static final bkwm z;
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_Bkwm = new bkwm("", -1);
    b = new bkwm("h5", 0);
    c = new bkwm("mainCamera", 1);
    d = new bkwm("", 2);
    e = new bkwm("aioMainCamera", 3);
    f = new bkwm("", 4);
    g = new bkwm("qzoneCamera", 5);
    h = new bkwm("", 6);
    i = new bkwm("aioGifCamera", 7);
    j = new bkwm("", 8);
    k = new bkwm("aioGroupSignin", 9);
    l = new bkwm("qzoneSignin", 10);
    m = new bkwm("qzoneBanner", 11);
    n = new bkwm("qzoneTail", 12);
    o = new bkwm("qzoneMoodList", 13);
    p = new bkwm("", 14);
    q = new bkwm("qzoneFriendPlus", 15);
    r = new bkwm("qzoneFriendState", 16);
    s = new bkwm("qzoneSlideCamera", 17);
    t = new bkwm("aioChats", 18);
    u = new bkwm("massSendBless", 19);
    v = new bkwm("qzonePublishFrame", 20);
    w = new bkwm("aioGifCameraTail", 23);
    x = new bkwm("circleCamera", 25);
    y = new bkwm("circlePickCamera", 26);
    z = new bkwm("qudongTakeFacePhoto", 1001, false);
  }
  
  private bkwm(String paramString, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = true;
  }
  
  private bkwm(String paramString, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static int a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return jdField_a_of_type_Bkwm.a();
    }
    return paramIntent.getIntExtra("VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Bkwm.a());
  }
  
  public static int a(bkle parambkle)
  {
    int i2 = 200;
    int i1 = i2;
    if (parambkle != null)
    {
      i1 = i2;
      if (parambkle.a() != null)
      {
        i1 = i2;
        if (parambkle.a().getIntent() != null) {
          i1 = parambkle.a().getIntent().getIntExtra("AECAMERA_MODE", 200);
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
  
  public static bkwm a(int paramInt)
  {
    bkwm[] arrayOfbkwm = jdField_a_of_type_ArrayOfBkwm;
    int i2 = arrayOfbkwm.length;
    int i1 = 0;
    while (i1 < i2)
    {
      bkwm localbkwm = arrayOfbkwm[i1];
      if (paramInt == localbkwm.a()) {
        return localbkwm;
      }
      i1 += 1;
    }
    return jdField_a_of_type_Bkwm;
  }
  
  public static bkwm a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return jdField_a_of_type_Bkwm;
    }
    bkwm[] arrayOfbkwm = jdField_a_of_type_ArrayOfBkwm;
    int i2 = arrayOfbkwm.length;
    int i1 = 0;
    if (i1 < i2)
    {
      bkwm localbkwm = arrayOfbkwm[i1];
      if (TextUtils.isEmpty(localbkwm.a())) {}
      while (!paramString.equals(localbkwm.a()))
      {
        i1 += 1;
        break;
      }
      return localbkwm;
    }
    return jdField_a_of_type_Bkwm;
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
        int i1 = paramActivity.getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Bkwm.a());
        if (i1 != A.a())
        {
          bool1 = bool2;
          if (i1 != z.a()) {}
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
    return d(paramActivity.getIntExtra("VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Bkwm.a()));
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
    for (int i1 = paramActivity.getIntExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Bkwm.a());; i1 = paramActivity.getIntExtra("VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Bkwm.a())) {
      return f(i1);
    }
  }
  
  public static boolean c(Intent paramIntent)
  {
    return (l(paramIntent)) || (m(paramIntent)) || (n(paramIntent));
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
      i1 = paramActivity.getIntExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Bkwm.a());
      if (n.a() != i1) {
        break label69;
      }
    }
    label69:
    for (boolean bool = true;; bool = false)
    {
      return bool;
      i1 = paramActivity.getIntExtra("VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Bkwm.a());
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
    return (paramIntent != null) && (a(paramIntent) == z.a());
  }
  
  public static boolean h(int paramInt)
  {
    return paramInt == x.a();
  }
  
  public static boolean h(Intent paramIntent)
  {
    return (paramIntent != null) && (a(paramIntent) == A.a());
  }
  
  public static boolean i(Intent paramIntent)
  {
    return (paramIntent != null) && (a(paramIntent) == x.a());
  }
  
  private static boolean j(Intent paramIntent)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramIntent != null)
    {
      bool1 = bool2;
      if (paramIntent.getIntExtra("VIDEO_STORY_FROM_TYPE", jdField_a_of_type_Bkwm.a()) == t.a()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static boolean k(Intent paramIntent)
  {
    return (paramIntent != null) && (paramIntent.getIntExtra("VIDEO_STORY_MEDIA_TYPE", 100) == 101);
  }
  
  private static boolean l(Intent paramIntent)
  {
    return (d(paramIntent)) && (k(paramIntent));
  }
  
  private static boolean m(Intent paramIntent)
  {
    return (j(paramIntent)) && (k(paramIntent));
  }
  
  private static boolean n(Intent paramIntent)
  {
    return (e(paramIntent)) && (k(paramIntent));
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
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
 * Qualified Name:     bkwm
 * JD-Core Version:    0.7.0.1
 */