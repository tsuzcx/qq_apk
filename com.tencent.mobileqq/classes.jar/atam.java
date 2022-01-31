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

public class atam
{
  private static Context jdField_a_of_type_AndroidContentContext;
  private static Map<String, atam> jdField_a_of_type_JavaUtilMap = new HashMap();
  public static int[] a;
  private static boolean d;
  private static boolean e;
  private long jdField_a_of_type_Long;
  protected BroadcastReceiver a;
  private atar jdField_a_of_type_Atar;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<atao> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private final String jdField_b_of_type_JavaLangString = "GroupVideoManager.IVPluginLoader";
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 3, 7, 9, 5, 10 };
  }
  
  private atam(Context paramContext, String paramString)
  {
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new atan(this);
    jdField_a_of_type_AndroidContentContext = paramContext.getApplicationContext();
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public static atam a(Context paramContext, String paramString)
  {
    atam localatam2 = (atam)jdField_a_of_type_JavaUtilMap.get(paramString);
    atam localatam1 = localatam2;
    if (localatam2 == null)
    {
      localatam1 = new atam(paramContext, paramString);
      jdField_a_of_type_JavaUtilMap.put(paramString, localatam1);
    }
    return localatam1;
  }
  
  private void a(int paramInt)
  {
    wxj.a("group_video", "loadPuginState", paramInt, (int)(SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long), new String[] { "", "", "", "8.3.5" });
    switch (paramInt)
    {
    case 4: 
    case 8: 
    default: 
      return;
    case 2: 
      atbh.b("2856626");
      return;
    case 3: 
      atbh.b("2856627");
      return;
    case 5: 
      atbh.b("2856629");
      return;
    case 6: 
      atbh.b("2856630");
      return;
    case 7: 
      atbh.b("2856631");
      return;
    }
    atbh.b("2856647");
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
    if (this.jdField_a_of_type_Atar != null) {
      this.jdField_a_of_type_Atar.a();
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, atao paramatao)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      localObject = new IntentFilter(atav.a(this.jdField_a_of_type_JavaLangString));
      ((IntentFilter)localObject).addAction(atav.b(this.jdField_a_of_type_JavaLangString));
      jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
      this.jdField_a_of_type_Boolean = true;
    }
    this.jdField_b_of_type_Boolean = TextUtils.equals(paramString5, "slientDownload");
    this.c = TextUtils.equals(paramString5, "download");
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramatao);
    paramatao = IVPluginInfo.a();
    Object localObject = (IVPluginInfo)paramatao.get(this.jdField_a_of_type_JavaLangString);
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
        atbh.b("2856624");
        this.jdField_a_of_type_Atar = atar.a(jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString, paramString1);
        ThreadManagerV2.executeOnSubThread(new IVPluginLoader.1(this, paramString2, paramString1, paramString4, paramString5, paramatao));
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
          atbh.b("2856625");
          this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
          wxj.a("group_video", "startLoad", 0, 0, new String[] { "", "", "", "8.3.5" });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atam
 * JD-Core Version:    0.7.0.1
 */