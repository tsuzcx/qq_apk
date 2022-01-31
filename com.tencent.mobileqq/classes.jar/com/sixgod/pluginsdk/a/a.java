package com.sixgod.pluginsdk.a;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.app.Instrumentation;
import android.app.Service;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.os.Bundle;
import android.os.IBinder;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.Window;
import com.sixgod.pluginsdk.common.Constants;
import java.io.File;

public final class a
{
  public g A;
  public g B;
  public g C;
  public g D;
  public g E;
  public g F;
  public g G;
  public g H;
  public g I;
  public g J;
  public g K;
  public g L;
  public g M;
  public g N;
  public g O;
  public g P;
  public g Q;
  public g R;
  public g S;
  public g T;
  public g U;
  public g V;
  public g W;
  public g X;
  public g Y;
  public g Z;
  public d a;
  public f aA;
  public f aB;
  public f aC;
  public f aD;
  public f aE;
  public f aF;
  public f aG;
  public f aH;
  public f aI;
  public f aJ;
  public f aK;
  public f aL;
  public f aM;
  public f aN;
  public f aO;
  public f aP;
  public f aQ;
  public f aR;
  public f aS;
  public f aT;
  public f aU;
  public f aV;
  public f aW;
  public f aX;
  public f aY;
  public f aZ;
  public g aa;
  public g ab;
  public g ac;
  public g ad;
  public g ae;
  public g af;
  public g ag;
  public g ah;
  public g ai;
  public g aj;
  public e ak;
  public e al;
  public e am;
  public e an;
  public e ao;
  public e ap;
  public e aq;
  public e ar;
  public e as;
  public e at;
  public f au;
  public f av;
  public f aw;
  public f ax;
  public f ay;
  public f az;
  public d b;
  public f ba;
  public f bb;
  public f bc;
  public f bd;
  public f be;
  public f bf;
  public f bg;
  public f bh;
  public f bi;
  public f bj;
  public f bk;
  public f bl;
  public f bm;
  public f bn;
  public f bo;
  public f bp;
  protected ClassLoader bq;
  public f br;
  public f bs;
  public f bt;
  public f bu;
  public f bv;
  public d c;
  public d d;
  public d e;
  public d f;
  public d g;
  public d h;
  public d i;
  public d j;
  public d k;
  public d l;
  public d m;
  public d n;
  public d o;
  public d p;
  public d q;
  public g r;
  public g s;
  public g t;
  public g u;
  public g v;
  public g w;
  public g x;
  public g y;
  public g z;
  
  public a(ClassLoader paramClassLoader)
  {
    this.bq = paramClassLoader;
    this.a = new d(this.bq, "android.content.pm.PackageParser");
    this.b = new d(this.bq, "android.content.pm.PackageParser$Package");
    this.c = new d(this.bq, "android.content.pm.PackageParser$Activity");
    this.d = new d(this.bq, "android.content.pm.PackageParser$Provider");
    this.o = new d(this.bq, "android.content.pm.PackageParser$Instrumentation");
    this.p = new d(this.bq, "android.content.pm.PackageParser$Permission");
    this.e = new d(this.bq, "android.content.pm.PackageParser$Service");
    this.f = new d(this.bq, "android.app.LoadedApk");
    this.g = new d(this.bq, "android.app.ActivityThread");
    this.h = new d(this.bq, "android.content.res.CompatibilityInfo");
    this.i = new d(this.bq, "android.app.Activity$NonConfigurationInstances");
    this.j = new d(this.bq, "android.app.ContextImpl");
    if (this.j.b == null) {
      this.j = new d(this.bq, "android.app.ApplicationContext");
    }
    this.k = new d(this.bq, "android.content.pm.PackageParser$ActivityIntentInfo");
    this.l = new d(this.bq, "android.content.pm.PackageParser$Component");
    this.m = new d(this.bq, "com.android.internal.app.IVoiceInteractor");
    this.n = new d(this.bq, "android.app.Application");
    this.q = new d(this.bq, "android.view.ViewRootImpl$ActivityConfigCallback");
    this.r = new g(this.a.b, "parsePackage", new Class[] { File.class, String.class, DisplayMetrics.class, Integer.TYPE });
    this.s = new g(this.a.b, "parsePackage", new Class[] { File.class, Integer.TYPE });
    this.ah = new g(this.a.b, "collectCertificates", new Class[] { this.b.b, Integer.TYPE });
    this.t = new g(this.g.b, "currentActivityThread", null);
    this.w = new g(Activity.class, "performRestart", null);
    this.v = new g(Activity.class, "performResume", null);
    this.u = new g(Activity.class, "performStart", null);
    this.x = new g(Activity.class, "performStop", null);
    this.y = new g(Activity.class, "performStop", new Class[] { Boolean.TYPE });
    this.z = new g(Activity.class, "onNewIntent", new Class[] { Intent.class });
    this.A = new g(Activity.class, "onSaveInstanceState", new Class[] { Bundle.class });
    this.B = new g(Activity.class, "onPause", null);
    this.C = new g(Activity.class, "performPause", null);
    this.D = new g(Activity.class, "onUserLeaveHint", null);
    this.E = new g(Activity.class, "onDestroy", null);
    this.F = new g(Activity.class, "performDestroy", null);
    this.H = new g(Activity.class, "onCreateDialog", new Class[] { Integer.TYPE });
    this.I = new g(Activity.class, "onPrepareDialog", new Class[] { Integer.TYPE, Dialog.class });
    this.J = new g(Activity.class, "onApplyThemeResource", new Class[] { Resources.Theme.class, Integer.TYPE, Boolean.TYPE });
    this.K = new g(Activity.class, "onActivityResult", new Class[] { Integer.TYPE, Integer.TYPE, Intent.class });
    this.L = new g(Activity.class, "onTitleChanged", new Class[] { CharSequence.class, Integer.TYPE });
    this.M = new g(Activity.class, "onChildTitleChanged", new Class[] { Activity.class, CharSequence.class });
    this.N = new g(Activity.class, "setParent", new Class[] { Activity.class });
    this.Z = new g(Activity.class, "attach", new Class[] { Context.class, this.g.b, Instrumentation.class, IBinder.class, Application.class, Intent.class, ActivityInfo.class, CharSequence.class, Activity.class, String.class, Object.class, Configuration.class });
    this.aa = new g(Activity.class, "attach", new Class[] { Context.class, this.g.b, Instrumentation.class, IBinder.class, Application.class, Intent.class, ActivityInfo.class, CharSequence.class, Activity.class, String.class, this.i.b, Configuration.class });
    if (this.m.a)
    {
      this.ab = new g(Activity.class, "attach", new Class[] { Context.class, this.g.b, Instrumentation.class, IBinder.class, Integer.TYPE, Application.class, Intent.class, ActivityInfo.class, CharSequence.class, Activity.class, String.class, this.i.b, Configuration.class, this.m.b });
      this.ac = new g(Activity.class, "attach", new Class[] { Context.class, this.g.b, Instrumentation.class, IBinder.class, Integer.TYPE, Application.class, Intent.class, ActivityInfo.class, CharSequence.class, Activity.class, String.class, this.i.b, Configuration.class, String.class, this.m.b });
      this.ad = new g(Activity.class, "attach", new Class[] { Context.class, this.g.b, Instrumentation.class, IBinder.class, Integer.TYPE, Application.class, Intent.class, ActivityInfo.class, CharSequence.class, Activity.class, String.class, this.i.b, Configuration.class, String.class, this.m.b, Window.class });
      if (this.q.a) {
        this.ae = new g(Activity.class, "attach", new Class[] { Context.class, this.g.b, Instrumentation.class, IBinder.class, Integer.TYPE, Application.class, Intent.class, ActivityInfo.class, CharSequence.class, Activity.class, String.class, this.i.b, Configuration.class, String.class, this.m.b, Window.class, this.q.b });
      }
    }
    this.G = new g(Activity.class, "onPostCreate", new Class[] { Bundle.class });
    this.ai = new g(Activity.class, "initActionBar", null);
    this.aj = new g(Activity.class, "initWindowDecorActionBar", null);
    this.O = new g(this.j.b, "init", new Class[] { this.f.b, IBinder.class, this.g.b });
    this.T = new g(this.j.b, "createAppContext", new Class[] { this.g.b, this.f.b });
    this.U = new g(this.j.b, "createActivityContext", new Class[] { this.g.b, this.f.b, IBinder.class });
    this.V = new g(this.j.b, "createActivityContext", new Class[] { this.g.b, this.f.b, Integer.TYPE, Configuration.class });
    this.W = new g(this.j.b, "createActivityContext", new Class[] { this.g.b, this.f.b, IBinder.class, Integer.TYPE, Configuration.class });
    this.P = new g(this.j.b, "setOuterContext", new Class[] { Context.class });
    this.Y = new g(this.j.b, "getPackageManager", null);
    this.Q = new g(Service.class, "attach", new Class[] { Context.class, this.g.b, String.class, IBinder.class, Application.class, Object.class });
    this.R = new g(Instrumentation.class, "newApplication", new Class[] { ClassLoader.class, String.class, Context.class });
    this.X = new g(Instrumentation.class, "newActivity", new Class[] { ClassLoader.class, String.class, Intent.class });
    this.ag = new g(Instrumentation.class, "callActivityOnCreate", new Class[] { Activity.class, Bundle.class });
    this.af = new g(this.f.b, "makeApplication", new Class[] { Boolean.TYPE, Instrumentation.class });
    this.S = new g(Application.class, "attach", new Class[] { Context.class });
    this.ak = new e(this.a, new Class[] { String.class });
    this.al = new e(this.a, null);
    paramClassLoader = this.g.b;
    Class localClass1 = this.g.b;
    Class localClass2 = Boolean.TYPE;
    Class localClass3 = Boolean.TYPE;
    this.am = new e(this.f, new Class[] { paramClassLoader, ApplicationInfo.class, localClass1, ClassLoader.class, localClass2, localClass3 });
    paramClassLoader = this.g.b;
    this.aq = new e(this.f, new Class[] { paramClassLoader, String.class, Context.class, ApplicationInfo.class });
    paramClassLoader = this.g.b;
    localClass1 = this.h.b;
    localClass2 = Boolean.TYPE;
    localClass3 = Boolean.TYPE;
    this.an = new e(this.f, new Class[] { paramClassLoader, ApplicationInfo.class, localClass1, ClassLoader.class, localClass2, localClass3 });
    paramClassLoader = this.g.b;
    this.ar = new e(this.f, new Class[] { paramClassLoader });
    paramClassLoader = this.g.b;
    localClass1 = this.h.b;
    localClass2 = this.g.b;
    localClass3 = Boolean.TYPE;
    Class localClass4 = Boolean.TYPE;
    this.ao = new e(this.f, new Class[] { paramClassLoader, ApplicationInfo.class, localClass1, localClass2, ClassLoader.class, localClass3, localClass4 });
    paramClassLoader = this.g.b;
    localClass1 = this.h.b;
    this.as = new e(this.f, new Class[] { paramClassLoader, String.class, Context.class, ApplicationInfo.class, localClass1 });
    paramClassLoader = this.g.b;
    localClass1 = this.h.b;
    localClass2 = Boolean.TYPE;
    localClass3 = Boolean.TYPE;
    localClass4 = Boolean.TYPE;
    this.ap = new e(this.f, new Class[] { paramClassLoader, ApplicationInfo.class, localClass1, ClassLoader.class, localClass2, localClass3, localClass4 });
    this.at = new e(this.j, null);
    this.au = new f(this.b.b, "applicationInfo");
    this.av = new f(ApplicationInfo.class, "sourceDir");
    this.aw = new f(Activity.class, "mMainThread");
    this.ax = new f(this.f.b, "mClassLoader");
    this.ay = new f(this.f.b, "mResDir");
    this.br = new f(this.f.b, "mAppDir");
    this.bs = new f(this.f.b, "mDataDir");
    this.bt = new f(this.f.b, "mDataDirFile");
    this.bu = new f(this.f.b, "mLibDir");
    this.az = new f(this.f.b, "mPackageName");
    this.aQ = new f(this.f.b, "mResources");
    this.bj = new f(this.f.b, "mApplication");
    this.bv = new f(this.f.b, "mApplicationInfo");
    this.aR = new f(this.j.b, "mResources");
    this.aS = new f(ContextThemeWrapper.class, "mResources");
    this.aA = new f(this.g.b, "mPackages");
    this.aB = new f(this.b.b, "activities");
    this.aC = new f(this.b.b, "services");
    this.aD = new f(this.b.b, "providers");
    this.aE = new f(this.b.b, "permissions");
    this.aM = new f(this.b.b, "instrumentation");
    this.aN = new f(this.b.b, "requestedPermissions");
    this.aO = new f(this.b.b, "configPreferences");
    this.aP = new f(this.b.b, "reqFeatures");
    this.aF = new f(this.c.b, "info");
    this.aG = new f(this.e.b, "info");
    this.aT = new f(Activity.class, "mResultCode");
    this.aU = new f(Activity.class, "mResultData");
    this.aV = new f(this.g.b, "mAllApplications");
    this.aW = new f(this.g.b, "mInstrumentation");
    this.aX = new f(ContextWrapper.class, "mBase");
    this.aY = new f(ContextThemeWrapper.class, "mBase");
    this.aZ = new f(this.c.b, "intents");
    this.ba = new f(this.k.b, "mCategories");
    this.bb = new f(this.l.b, "intents");
    this.bc = new f(this.b.b, "receivers");
    this.bd = new f(Activity.class, "mToken");
    this.be = new f(Service.class, "mToken");
    localClass1 = this.g.b;
    if (Constants.ANDROID_VERSION <= 10) {}
    for (paramClassLoader = "mConfiguration";; paramClassLoader = "mCompatConfiguration")
    {
      this.bf = new f(localClass1, paramClassLoader);
      this.bg = new f(Activity.class, "mStartedActivity");
      this.bh = new f(Activity.class, "mCalled");
      if (Constants.ANDROID_VERSION > 10) {
        this.bi = new f(this.j.b, "mBasePackageName");
      }
      this.bk = new f(this.b.b, "mSignatures");
      this.aH = new f(this.b.b, "mVersionCode");
      this.aI = new f(this.b.b, "mVersionName");
      this.aJ = new f(this.b.b, "mSharedUserId");
      this.aK = new f(this.b.b, "mSharedUserLabel");
      this.aL = new f(this.b.b, "mAppMetaData");
      this.bl = new f(this.n.b, "mLoadedApk");
      this.bm = new f(this.d.b, "info");
      this.bn = new f(this.o.b, "info");
      this.bo = new f(this.p.b, "info");
      this.bp = new f(this.j.b, "mResources");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.sixgod.pluginsdk.a.a
 * JD-Core Version:    0.7.0.1
 */