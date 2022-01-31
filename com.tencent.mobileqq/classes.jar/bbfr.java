import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import com.tencent.mobileqq.werewolves.WerewolvesHostInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

public class bbfr
{
  Context jdField_a_of_type_AndroidContentContext;
  WerewolvesHostInterface jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesHostInterface;
  Class jdField_a_of_type_JavaLangClass;
  ClassLoader jdField_a_of_type_JavaLangClassLoader;
  Object jdField_a_of_type_JavaLangObject;
  Method jdField_a_of_type_JavaLangReflectMethod = null;
  boolean jdField_a_of_type_Boolean = false;
  Class jdField_b_of_type_JavaLangClass;
  Object jdField_b_of_type_JavaLangObject;
  Method jdField_b_of_type_JavaLangReflectMethod;
  Method c = null;
  Method d = null;
  Method e = null;
  Method f = null;
  Method g = null;
  Method h = null;
  Method i = null;
  Method j = null;
  Method k = null;
  Method l;
  Method m = null;
  Method n = null;
  Method o;
  Method p;
  Method q;
  Method r;
  Method s = null;
  Method t = null;
  Method u;
  Method v;
  Method w;
  Method x;
  Method y;
  
  public bbfr(bbfs parambbfs, ClassLoader paramClassLoader)
  {
    this.jdField_a_of_type_JavaLangClassLoader = paramClassLoader;
    this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesHostInterface = new WerewolvesHostInterface(parambbfs);
    a(parambbfs.a.a);
  }
  
  public int a()
  {
    try
    {
      int i1 = ((Integer)this.w.invoke(this.jdField_b_of_type_JavaLangObject, new Object[0])).intValue();
      return i1;
    }
    catch (Exception localException)
    {
      QLog.e("WereWolfPluginInterface", 2, "getCurRoomNumber Failed:", localException);
    }
    return 10;
  }
  
  public String a(String paramString)
  {
    try
    {
      paramString = (String)this.n.invoke(this.jdField_b_of_type_JavaLangObject, new Object[] { paramString });
      return paramString;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("WereWolfPluginInterface", 2, "getRoomIndex called failed");
        QLog.e("WereWolfPluginInterface", 2, paramString, new Object[0]);
      }
    }
    return null;
  }
  
  public ArrayList<String> a()
  {
    try
    {
      ArrayList localArrayList = (ArrayList)this.o.invoke(this.jdField_b_of_type_JavaLangObject, new Object[0]);
      return localArrayList;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("WereWolfPluginInterface", 2, "getQuickWords called failed");
        QLog.e("WereWolfPluginInterface", 2, localException, new Object[0]);
      }
    }
    return null;
  }
  
  public HashMap<String, Integer> a()
  {
    try
    {
      HashMap localHashMap = (HashMap)this.q.invoke(this.jdField_b_of_type_JavaLangObject, new Object[0]);
      return localHashMap;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WereWolfPluginInterface", 2, "getAIOColors called failed", localException);
      }
    }
    return null;
  }
  
  public void a()
  {
    try
    {
      this.d.invoke(this.jdField_b_of_type_JavaLangObject, new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("WereWolfPluginInterface", 2, "onDestroy called failed");
        QLog.e("WereWolfPluginInterface", 2, localException, new Object[0]);
      }
      return;
    }
    finally
    {
      this.jdField_a_of_type_AndroidContentContext = null;
    }
  }
  
  public void a(int paramInt)
  {
    try
    {
      if (this.y != null) {
        this.y.invoke(this.jdField_b_of_type_JavaLangObject, new Object[] { Integer.valueOf(paramInt) });
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("WereWolfPluginInterface", 2, "onPhoneStateChange called failed");
      QLog.e("WereWolfPluginInterface", 2, localException, new Object[0]);
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    try
    {
      this.jdField_b_of_type_JavaLangReflectMethod.invoke(this.jdField_b_of_type_JavaLangObject, new Object[] { Integer.valueOf(paramInt), paramObject });
      return;
    }
    catch (Exception paramObject)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("WereWolfPluginInterface", 2, "notify failed", paramObject);
    }
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangClass = bbfa.a(this.jdField_a_of_type_JavaLangClassLoader, "com.tencent.mobileqq.werewolves.PluginRuntime");
    this.jdField_b_of_type_JavaLangClass = bbfa.a(this.jdField_a_of_type_JavaLangClassLoader, "com.tencent.mobileqq.werewolves.PluginInterface");
    try
    {
      if (this.jdField_a_of_type_JavaLangObject == null) {
        this.jdField_a_of_type_JavaLangObject = bbfa.a(this.jdField_a_of_type_JavaLangClass, "getRuntime", null).invoke(null, null);
      }
      bbfa.a(this.jdField_a_of_type_JavaLangClass, "initFromHost", new Class[] { Object.class, Context.class }).invoke(this.jdField_a_of_type_JavaLangObject, new Object[] { this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesHostInterface, paramContext });
      this.jdField_b_of_type_JavaLangObject = bbfa.a(this.jdField_a_of_type_JavaLangClass, "getPlulginInterface", null).invoke(this.jdField_a_of_type_JavaLangObject, null);
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("WereWolfPluginInterface", 2, "init failed");
          QLog.e("WereWolfPluginInterface", 2, paramContext, new Object[0]);
        }
      }
    }
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_JavaLangClass != null))
    {
      this.jdField_a_of_type_JavaLangReflectMethod = bbfa.a(this.jdField_b_of_type_JavaLangClass, "onReceive", new Class[] { Integer.TYPE, String.class, [B.class });
      this.c = bbfa.a(this.jdField_b_of_type_JavaLangClass, "attachGameUI", new Class[] { ViewGroup.class, Context.class });
      this.d = bbfa.a(this.jdField_b_of_type_JavaLangClass, "onDestroy", new Class[0]);
      this.f = bbfa.a(this.jdField_b_of_type_JavaLangClass, "isReady", new Class[0]);
      this.g = bbfa.a(this.jdField_b_of_type_JavaLangClass, "isPlaying", new Class[0]);
      this.h = bbfa.a(this.jdField_b_of_type_JavaLangClass, "isDead", new Class[0]);
      this.i = bbfa.a(this.jdField_b_of_type_JavaLangClass, "canSpeak", new Class[0]);
      this.j = bbfa.a(this.jdField_b_of_type_JavaLangClass, "onFaceDownloaded", new Class[] { String.class, Bitmap.class });
      this.o = bbfa.a(this.jdField_b_of_type_JavaLangClass, "getQuickWords", new Class[0]);
      this.m = bbfa.a(this.jdField_b_of_type_JavaLangClass, "stopGame", new Class[0]);
      this.k = bbfa.a(this.jdField_b_of_type_JavaLangClass, "startGame", new Class[] { Integer.TYPE });
      this.l = bbfa.a(this.jdField_b_of_type_JavaLangClass, "startGameWithType", new Class[] { Integer.TYPE });
      this.n = bbfa.a(this.jdField_b_of_type_JavaLangClass, "getRoomNick", new Class[] { String.class });
      this.p = bbfa.a(this.jdField_b_of_type_JavaLangClass, "onUserSpeakingStateChanged", new Class[] { String.class, Boolean.TYPE });
      this.q = bbfa.a(this.jdField_b_of_type_JavaLangClass, "getAIOColors", new Class[0]);
      this.r = bbfa.a(this.jdField_b_of_type_JavaLangClass, "getAIODrawables", new Class[] { Context.class });
      this.e = bbfa.a(this.jdField_b_of_type_JavaLangClass, "dettachGameUI", new Class[0]);
      this.s = bbfa.a(this.jdField_b_of_type_JavaLangClass, "onUserLeftAIO", new Class[0]);
      this.t = bbfa.a(this.jdField_b_of_type_JavaLangClass, "onUserEnterAIO", new Class[0]);
      this.u = bbfa.a(this.jdField_b_of_type_JavaLangClass, "onSpeakBtnPressed", new Class[] { Boolean.TYPE });
      this.v = bbfa.a(this.jdField_b_of_type_JavaLangClass, "startGameForGold", new Class[0]);
      this.x = bbfa.a(this.jdField_b_of_type_JavaLangClass, "getCurZoneId", new Class[0]);
      this.w = bbfa.a(this.jdField_b_of_type_JavaLangClass, "getCurRoomNumber", new Class[0]);
      this.jdField_b_of_type_JavaLangReflectMethod = bbfa.a(this.jdField_b_of_type_JavaLangClass, "notify", new Class[] { Integer.TYPE, Object.class });
      this.y = bbfa.a(this.jdField_b_of_type_JavaLangClass, "onPhoneStateChange", new Class[] { Integer.TYPE });
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void a(ViewGroup paramViewGroup, xah paramxah)
  {
    try
    {
      this.c.invoke(this.jdField_b_of_type_JavaLangObject, new Object[] { paramViewGroup, paramxah });
      return;
    }
    catch (Exception paramViewGroup)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("WereWolfPluginInterface", 2, "attachGameUI called failed");
      QLog.e("WereWolfPluginInterface", 2, paramViewGroup, new Object[0]);
    }
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    try
    {
      this.j.invoke(this.jdField_b_of_type_JavaLangObject, new Object[] { paramString, paramBitmap });
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("WereWolfPluginInterface", 2, "onFaceDownloaded called failed");
      QLog.e("WereWolfPluginInterface", 2, paramString, new Object[0]);
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    try
    {
      this.p.invoke(this.jdField_b_of_type_JavaLangObject, new Object[] { paramString, Boolean.valueOf(paramBoolean) });
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("WereWolfPluginInterface", 2, "onUserSpeakingStateChanged called failed");
        QLog.e("WereWolfPluginInterface", 2, paramString, new Object[0]);
      }
      paramString.printStackTrace();
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    try
    {
      this.jdField_a_of_type_JavaLangReflectMethod.invoke(this.jdField_b_of_type_JavaLangObject, new Object[] { Integer.valueOf(1), paramString, paramArrayOfByte });
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("WereWolfPluginInterface", 2, "onReceive called failed");
      QLog.e("WereWolfPluginInterface", 2, paramString, new Object[0]);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      this.u.invoke(this.jdField_b_of_type_JavaLangObject, new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("WereWolfPluginInterface", 2, "onSpeakBtnPressed called failed");
      QLog.e("WereWolfPluginInterface", 2, localException, new Object[0]);
    }
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = ((Boolean)this.f.invoke(this.jdField_b_of_type_JavaLangObject, new Object[0])).booleanValue();
      if (QLog.isColorLevel()) {
        QLog.d("WereWolfPluginInterface", 2, "isReady = " + bool);
      }
      return bool;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("WereWolfPluginInterface", 2, "isReady called failed");
        QLog.e("WereWolfPluginInterface", 2, localException, new Object[0]);
      }
    }
    return false;
  }
  
  public int b()
  {
    try
    {
      int i1 = ((Integer)this.x.invoke(this.jdField_b_of_type_JavaLangObject, new Object[0])).intValue();
      return i1;
    }
    catch (Exception localException)
    {
      QLog.e("WereWolfPluginInterface", 2, "getCurZoneId Failed:", localException);
    }
    return 0;
  }
  
  public HashMap<String, Drawable> b()
  {
    try
    {
      HashMap localHashMap = (HashMap)this.r.invoke(this.jdField_b_of_type_JavaLangObject, new Object[] { this.jdField_a_of_type_AndroidContentContext });
      return localHashMap;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WereWolfPluginInterface", 2, "getAIODrawables called failed", localException);
      }
    }
    return null;
  }
  
  public void b()
  {
    try
    {
      this.e.invoke(this.jdField_b_of_type_JavaLangObject, new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("WereWolfPluginInterface", 2, "dettachUI called failed");
        QLog.e("WereWolfPluginInterface", 2, localException, new Object[0]);
      }
      return;
    }
    finally
    {
      this.jdField_a_of_type_AndroidContentContext = null;
    }
  }
  
  public boolean b()
  {
    try
    {
      boolean bool = ((Boolean)this.g.invoke(this.jdField_b_of_type_JavaLangObject, new Object[0])).booleanValue();
      if (QLog.isColorLevel()) {
        QLog.d("WereWolfPluginInterface", 2, "isPlaying = " + bool);
      }
      return bool;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("WereWolfPluginInterface", 2, "isPlaying called failed");
        QLog.e("WereWolfPluginInterface", 2, localException, new Object[0]);
      }
    }
    return false;
  }
  
  public void c()
  {
    try
    {
      this.s.invoke(this.jdField_b_of_type_JavaLangObject, new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("WereWolfPluginInterface", 2, "onUserLeftAIO called failed");
        QLog.e("WereWolfPluginInterface", 2, localException, new Object[0]);
      }
      localException.printStackTrace();
    }
  }
  
  public boolean c()
  {
    try
    {
      boolean bool = ((Boolean)this.h.invoke(this.jdField_b_of_type_JavaLangObject, new Object[0])).booleanValue();
      if (QLog.isColorLevel()) {
        QLog.d("WereWolfPluginInterface", 2, "isDead = " + bool);
      }
      return bool;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("WereWolfPluginInterface", 2, "isDead called failed");
        QLog.e("WereWolfPluginInterface", 2, localException, new Object[0]);
      }
    }
    return false;
  }
  
  public void d()
  {
    try
    {
      this.t.invoke(this.jdField_b_of_type_JavaLangObject, new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("WereWolfPluginInterface", 2, "onUserEnterAIO called failed");
      QLog.e("WereWolfPluginInterface", 2, localException, new Object[0]);
    }
  }
  
  public boolean d()
  {
    try
    {
      boolean bool = ((Boolean)this.i.invoke(this.jdField_b_of_type_JavaLangObject, new Object[0])).booleanValue();
      if (QLog.isColorLevel()) {
        QLog.d("WereWolfPluginInterface", 2, "canSpeak = " + bool);
      }
      return bool;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("WereWolfPluginInterface", 2, "canSpeak called failed");
        QLog.e("WereWolfPluginInterface", 2, localException, new Object[0]);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bbfr
 * JD-Core Version:    0.7.0.1
 */