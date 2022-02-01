package com.tencent.aelight.camera.ae.entry;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.aelight.camera.ae.AEBaseCameraUnit;
import com.tencent.aelight.camera.ae.AECameraConfig;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.mode.AECaptureMode;
import com.tencent.aelight.camera.entry.api.AECameraEntry;
import java.util.HashMap;
import java.util.Map;

public class AECameraEntryManager
{
  public static int a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return AECameraEntry.a.a();
    }
    return paramIntent.getIntExtra("VIDEO_STORY_FROM_TYPE", AECameraEntry.a.a());
  }
  
  public static int a(AEBaseCameraUnit paramAEBaseCameraUnit)
  {
    if ((paramAEBaseCameraUnit != null) && (paramAEBaseCameraUnit.u() != null)) {
      return paramAEBaseCameraUnit.u().w();
    }
    if ((paramAEBaseCameraUnit != null) && (paramAEBaseCameraUnit.s() != null) && (paramAEBaseCameraUnit.s().getIntent() != null)) {
      return paramAEBaseCameraUnit.s().getIntent().getIntExtra("AECAMERA_MODE", 200);
    }
    return 200;
  }
  
  public static int a(String paramString)
  {
    HashMap localHashMap = new HashMap(4);
    localHashMap.put("camera", Integer.valueOf(200));
    localHashMap.put("all", Integer.valueOf(201));
    localHashMap.put("gif", Integer.valueOf(202));
    localHashMap.put("singlegif", Integer.valueOf(203));
    localHashMap.put("cameraAndPlay", Integer.valueOf(204));
    localHashMap.put("cameraAndGif", Integer.valueOf(205));
    localHashMap.put("play", Integer.valueOf(206));
    localHashMap.put("playAndGif", Integer.valueOf(207));
    localHashMap.put("arCake", Integer.valueOf(208));
    if ((paramString != null) && (localHashMap.containsKey(paramString)) && (localHashMap.get(paramString) != null)) {
      return ((Integer)localHashMap.get(paramString)).intValue();
    }
    return 200;
  }
  
  public static boolean a(int paramInt)
  {
    return paramInt == AECameraEntry.t.a();
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
        int i = paramActivity.getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", AECameraEntry.a.a());
        if (i != AECameraEntry.N.a())
        {
          bool1 = bool2;
          if (i != AECameraEntry.M.a()) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(Intent paramIntent, int paramInt)
  {
    return (paramInt == 14) && (!c(paramIntent)) && (!e(paramIntent));
  }
  
  public static boolean a(AEPituCameraUnit paramAEPituCameraUnit)
  {
    if ((paramAEPituCameraUnit != null) && (paramAEPituCameraUnit.s() != null)) {
      return o(paramAEPituCameraUnit.s().getIntent());
    }
    return false;
  }
  
  public static int b(Intent paramIntent)
  {
    if (paramIntent == null) {
      return 0;
    }
    return paramIntent.getIntExtra("VIDEO_STORY_JUMP_TO_TYPE", 0);
  }
  
  @NonNull
  public static String b(@Nullable String paramString)
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
  
  public static boolean b(int paramInt)
  {
    return AECameraEntry.n.a() == paramInt;
  }
  
  public static boolean b(Activity paramActivity)
  {
    if (paramActivity == null) {
      return false;
    }
    paramActivity = paramActivity.getIntent();
    if (paramActivity == null) {
      return false;
    }
    return c(paramActivity.getIntExtra("VIDEO_STORY_FROM_TYPE", AECameraEntry.a.a()));
  }
  
  public static boolean c(int paramInt)
  {
    return (paramInt == AECameraEntry.g.a()) || (paramInt == AECameraEntry.o.a()) || (paramInt == AECameraEntry.r.a()) || (paramInt == AECameraEntry.e.a()) || (paramInt == AECameraEntry.v.a());
  }
  
  public static boolean c(Activity paramActivity)
  {
    if (paramActivity == null) {
      return false;
    }
    paramActivity = paramActivity.getIntent();
    if (paramActivity == null) {
      return false;
    }
    return e(h(paramActivity));
  }
  
  public static boolean c(Intent paramIntent)
  {
    return (paramIntent == null) || (paramIntent.getIntExtra("VIDEO_STORY_JUMP_TO_TYPE", 0) == 0);
  }
  
  public static int d(Intent paramIntent)
  {
    if (paramIntent == null) {
      return 100;
    }
    return paramIntent.getIntExtra("VIDEO_STORY_MEDIA_TYPE", 100);
  }
  
  public static boolean d(int paramInt)
  {
    return paramInt == AECameraEntry.c.a();
  }
  
  public static boolean d(Activity paramActivity)
  {
    boolean bool = false;
    if (paramActivity == null) {
      return false;
    }
    paramActivity = paramActivity.getIntent();
    if (paramActivity == null) {
      return false;
    }
    int i = h(paramActivity);
    if (AECameraEntry.n.a() == i) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean e(int paramInt)
  {
    return (paramInt == AECameraEntry.g.a()) || (paramInt == AECameraEntry.o.a()) || (paramInt == AECameraEntry.r.a()) || (paramInt == AECameraEntry.v.a());
  }
  
  public static boolean e(Intent paramIntent)
  {
    return (paramIntent == null) || (paramIntent.getIntExtra("VIDEO_STORY_MEDIA_TYPE", 100) == 100);
  }
  
  public static boolean f(int paramInt)
  {
    return AECameraEntry.e.a() == paramInt;
  }
  
  public static boolean f(Intent paramIntent)
  {
    return (x(paramIntent)) || (y(paramIntent)) || (z(paramIntent));
  }
  
  public static boolean g(int paramInt)
  {
    return (paramInt == AECameraEntry.x.a()) || (h(paramInt)) || (i(paramInt)) || (j(paramInt));
  }
  
  public static boolean g(Intent paramIntent)
  {
    return (paramIntent != null) && (a(paramIntent) == AECameraEntry.n.a());
  }
  
  public static int h(Intent paramIntent)
  {
    if (paramIntent.hasExtra("ORIGIN_VIDEO_STORY_FROM_TYPE")) {
      return paramIntent.getIntExtra("ORIGIN_VIDEO_STORY_FROM_TYPE", AECameraEntry.a.a());
    }
    return paramIntent.getIntExtra("VIDEO_STORY_FROM_TYPE", AECameraEntry.a.a());
  }
  
  public static boolean h(int paramInt)
  {
    return (paramInt == AECameraEntry.A.a()) || (paramInt == AECameraEntry.z.a());
  }
  
  public static boolean i(int paramInt)
  {
    return paramInt == AECameraEntry.E.a();
  }
  
  public static boolean i(Intent paramIntent)
  {
    int i = a(paramIntent);
    return (i == AECameraEntry.k.a()) || (i == AECameraEntry.l.a());
  }
  
  public static boolean j(int paramInt)
  {
    return paramInt == AECameraEntry.K.a();
  }
  
  public static boolean j(Intent paramIntent)
  {
    int i = a(paramIntent);
    return (i == AECameraEntry.H.a()) || (i == AECameraEntry.I.a());
  }
  
  public static boolean k(int paramInt)
  {
    return (paramInt != AECameraEntry.e.a()) && (paramInt != AECameraEntry.i.a()) && (paramInt != AECameraEntry.p.a()) && (paramInt != AECameraEntry.w.a()) && (paramInt != AECameraEntry.x.a()) && (paramInt != AECameraEntry.M.a()) && (paramInt != AECameraEntry.N.a());
  }
  
  public static boolean k(Intent paramIntent)
  {
    return (paramIntent != null) && (a(paramIntent) == AECameraEntry.e.a());
  }
  
  public static boolean l(Intent paramIntent)
  {
    return (paramIntent != null) && (a(paramIntent) == AECameraEntry.i.a());
  }
  
  public static boolean m(Intent paramIntent)
  {
    return (paramIntent != null) && (a(paramIntent) == AECameraEntry.M.a());
  }
  
  public static boolean n(Intent paramIntent)
  {
    return (paramIntent != null) && (a(paramIntent) == AECameraEntry.N.a());
  }
  
  public static boolean o(Intent paramIntent)
  {
    return ((paramIntent != null) && ((a(paramIntent) == AECameraEntry.x.a()) || (r(paramIntent)))) || (t(paramIntent)) || (u(paramIntent));
  }
  
  public static boolean p(Intent paramIntent)
  {
    return (paramIntent != null) && (a(paramIntent) == AECameraEntry.L.a());
  }
  
  public static boolean q(Intent paramIntent)
  {
    return (paramIntent != null) && (a(paramIntent) == AECameraEntry.J.a());
  }
  
  public static boolean r(Intent paramIntent)
  {
    return (paramIntent != null) && ((a(paramIntent) == AECameraEntry.z.a()) || (a(paramIntent) == AECameraEntry.A.a()));
  }
  
  public static boolean s(Intent paramIntent)
  {
    boolean bool = false;
    if (paramIntent == null) {
      return false;
    }
    int i = a(paramIntent);
    if ((i == AECameraEntry.F.a()) || (i == AECameraEntry.G.a()) || (i == AECameraEntry.D.a())) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean t(Intent paramIntent)
  {
    return (paramIntent != null) && (a(paramIntent) == AECameraEntry.E.a());
  }
  
  public static boolean u(Intent paramIntent)
  {
    boolean bool;
    if ((paramIntent != null) && (a(paramIntent) == AECameraEntry.K.a())) {
      bool = true;
    } else {
      bool = false;
    }
    return Boolean.valueOf(bool).booleanValue();
  }
  
  private static boolean v(Intent paramIntent)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramIntent != null)
    {
      bool1 = bool2;
      if (paramIntent.getIntExtra("VIDEO_STORY_FROM_TYPE", AECameraEntry.a.a()) == AECameraEntry.t.a()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static boolean w(Intent paramIntent)
  {
    return (paramIntent != null) && (paramIntent.getIntExtra("VIDEO_STORY_MEDIA_TYPE", 100) == 101);
  }
  
  private static boolean x(Intent paramIntent)
  {
    return (g(paramIntent)) && (w(paramIntent));
  }
  
  private static boolean y(Intent paramIntent)
  {
    return (v(paramIntent)) && (w(paramIntent));
  }
  
  private static boolean z(Intent paramIntent)
  {
    return (i(paramIntent)) && (w(paramIntent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.entry.AECameraEntryManager
 * JD-Core Version:    0.7.0.1
 */