import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Environment;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginLoader.1;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class aqli
{
  private static Map<String, aqli> jdField_a_of_type_JavaUtilMap = new HashMap();
  public static int[] a;
  private static boolean d;
  private static boolean e;
  private long jdField_a_of_type_Long;
  protected BroadcastReceiver a;
  private Context jdField_a_of_type_AndroidContentContext;
  private aqln jdField_a_of_type_Aqln;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<aqlk> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private final String jdField_b_of_type_JavaLangString = "GroupVideoManager.IVPluginLoader";
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 3, 7, 9, 5, 10 };
  }
  
  private aqli(Context paramContext, String paramString)
  {
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new aqlj(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public static aqli a(Context paramContext, String paramString)
  {
    aqli localaqli2 = (aqli)jdField_a_of_type_JavaUtilMap.get(paramString);
    aqli localaqli1 = localaqli2;
    if (localaqli2 == null)
    {
      localaqli1 = new aqli(paramContext, paramString);
      jdField_a_of_type_JavaUtilMap.put(paramString, localaqli1);
    }
    return localaqli1;
  }
  
  private void a(int paramInt)
  {
    urp.a("group_video", "loadPuginState", paramInt, (int)(SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long), new String[] { "", "", "", "8.2.6" });
    switch (paramInt)
    {
    case 4: 
    case 8: 
    default: 
      return;
    case 2: 
      aqmd.b("2856626");
      return;
    case 3: 
      aqmd.b("2856627");
      return;
    case 5: 
      aqmd.b("2856629");
      return;
    case 6: 
      aqmd.b("2856630");
      return;
    case 7: 
      aqmd.b("2856631");
      return;
    }
    aqmd.b("2856647");
  }
  
  public static boolean a()
  {
    if (e) {
      return d;
    }
    try
    {
      File localFile = new File(Environment.getExternalStorageDirectory(), "versionchecker.test");
      if (localFile != null)
      {
        d = localFile.exists();
        e = true;
      }
      return d;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        Object localObject = null;
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aqln != null) {
      this.jdField_a_of_type_Aqln.a();
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, aqlk paramaqlk)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      localObject = new IntentFilter(aqlr.a(this.jdField_a_of_type_JavaLangString));
      ((IntentFilter)localObject).addAction(aqlr.b(this.jdField_a_of_type_JavaLangString));
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
      this.jdField_a_of_type_Boolean = true;
    }
    this.jdField_b_of_type_Boolean = TextUtils.equals(paramString5, "slientDownload");
    this.c = TextUtils.equals(paramString5, "download");
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramaqlk);
    paramaqlk = IVPluginInfo.a();
    Object localObject = (IVPluginInfo)paramaqlk.get(this.jdField_a_of_type_JavaLangString);
    if (!TextUtils.isEmpty(paramString3)) {}
    try
    {
      ((IVPluginInfo)localObject).jdField_a_of_type_Long = Long.parseLong(paramString3);
      if (!TextUtils.isEmpty(paramString6)) {
        ((IVPluginInfo)localObject).e = paramString6;
      }
      ((IVPluginInfo)localObject).h = paramString7;
      ((IVPluginInfo)localObject).c = paramInt;
      ((IVPluginInfo)localObject).i = paramString8;
      ((IVPluginInfo)localObject).j = paramString9;
      if (this.jdField_b_of_type_Boolean)
      {
        aqmd.b("2856624");
        this.jdField_a_of_type_Aqln = aqln.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, paramString1);
        ThreadManagerV2.executeOnSubThread(new IVPluginLoader.1(this, paramString2, paramString1, paramString4, paramString5, paramaqlk));
        return;
      }
    }
    catch (NumberFormatException paramString3)
    {
      for (;;)
      {
        paramString3.printStackTrace();
        continue;
        if (this.c)
        {
          aqmd.b("2856625");
          this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
          urp.a("group_video", "startLoad", 0, 0, new String[] { "", "", "", "8.2.6" });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aqli
 * JD-Core Version:    0.7.0.1
 */