import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginLoader.1;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class avig
{
  private static Context jdField_a_of_type_AndroidContentContext;
  private static Map<String, avig> jdField_a_of_type_JavaUtilMap = new HashMap();
  public static int[] a;
  private static boolean d;
  private static boolean e;
  private long jdField_a_of_type_Long;
  protected BroadcastReceiver a;
  private avil jdField_a_of_type_Avil;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<avii> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private final String jdField_b_of_type_JavaLangString = "GroupVideoManager.IVPluginLoader";
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 3, 7, 9, 5, 10 };
  }
  
  private avig(Context paramContext, String paramString)
  {
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new avih(this);
    jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public static avig a(Context paramContext, String paramString)
  {
    avig localavig2 = (avig)jdField_a_of_type_JavaUtilMap.get(paramString);
    avig localavig1 = localavig2;
    if (localavig2 == null)
    {
      localavig1 = new avig(paramContext, paramString);
      jdField_a_of_type_JavaUtilMap.put(paramString, localavig1);
    }
    return localavig1;
  }
  
  private void a(int paramInt)
  {
    yqu.a("group_video", "loadPuginState", paramInt, (int)(SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long), new String[] { "", "", "", "8.4.1" });
    switch (paramInt)
    {
    case 4: 
    case 8: 
    default: 
      return;
    case 2: 
      avjb.b("2856626");
      return;
    case 3: 
      avjb.b("2856627");
      return;
    case 5: 
      avjb.b("2856629");
      return;
    case 6: 
      avjb.b("2856630");
      return;
    case 7: 
      avjb.b("2856631");
      return;
    }
    avjb.b("2856647");
  }
  
  public static boolean a()
  {
    if (e) {
      return d;
    }
    try
    {
      File localFile = new File(jdField_a_of_type_AndroidContentContext.getExternalFilesDir(null).getPath(), "versionchecker.test");
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
    if (this.jdField_a_of_type_Avil != null) {
      this.jdField_a_of_type_Avil.a();
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, avii paramavii)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      localObject = new IntentFilter(avip.a(this.jdField_a_of_type_JavaLangString));
      ((IntentFilter)localObject).addAction(avip.b(this.jdField_a_of_type_JavaLangString));
      jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
      this.jdField_a_of_type_Boolean = true;
    }
    this.jdField_b_of_type_Boolean = TextUtils.equals(paramString5, "slientDownload");
    this.c = TextUtils.equals(paramString5, "download");
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramavii);
    paramavii = IVPluginInfo.a();
    Object localObject = (IVPluginInfo)paramavii.get(this.jdField_a_of_type_JavaLangString);
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
        avjb.b("2856624");
        this.jdField_a_of_type_Avil = avil.a(jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, paramString1);
        ThreadManagerV2.executeOnSubThread(new IVPluginLoader.1(this, paramString2, paramString1, paramString4, paramString5, paramavii));
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
          avjb.b("2856625");
          this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
          yqu.a("group_video", "startLoad", 0, 0, new String[] { "", "", "", "8.4.1" });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avig
 * JD-Core Version:    0.7.0.1
 */