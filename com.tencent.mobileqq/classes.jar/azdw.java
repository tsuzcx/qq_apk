import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qassistant.audio.VoiceTimeTraceUtil.1;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class azdw
{
  private volatile azds jdField_a_of_type_Azds;
  private Map<azdo, azdv> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private Map<String, String> b = new ConcurrentHashMap();
  
  public static azdw a()
  {
    return azdx.a();
  }
  
  public String a(String paramString)
  {
    return "";
  }
  
  public void a() {}
  
  public void a(Activity paramActivity)
  {
    if ((!azgf.a()) || (paramActivity == null))
    {
      QQToast.a(paramActivity, "转发环境错误", 0).a();
      return;
    }
    Object localObject = (azfg)azeu.a().getManager(387);
    if ((localObject != null) && (((azfg)localObject).b())) {
      ((azfg)localObject).a(true, false);
    }
    azeu.a("VoiceTimeTraceUtil", "snapshotList:" + this.b.toString());
    if (this.b.isEmpty())
    {
      QQToast.a(paramActivity, "快照文件为空", 0).a();
      return;
    }
    if (((this.b.get("SLK") == null) || (!FileUtils.isEmptyFile((String)this.b.get("SLK")))) || (((this.b.get("PCM") == null) || (!FileUtils.isEmptyFile((String)this.b.get("PCM")))) || ((this.b.get("BUF") != null) && (FileUtils.isEmptyFile((String)this.b.get("BUF")))))) {}
    localObject = new ArrayList(this.b.values().size());
    ThreadManager.getFileThreadHandler().post(new VoiceTimeTraceUtil.1(this, (List)localObject, paramActivity));
  }
  
  public void a(azdo paramazdo)
  {
    azdv localazdv2 = (azdv)this.jdField_a_of_type_JavaUtilMap.get(paramazdo);
    azdv localazdv1 = localazdv2;
    if (localazdv2 == null) {
      localazdv1 = new azdv();
    }
    localazdv1.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_JavaUtilMap.put(paramazdo, localazdv1);
  }
  
  public void a(azdo paramazdo, int paramInt1, int paramInt2)
  {
    azdv localazdv2 = (azdv)this.jdField_a_of_type_JavaUtilMap.get(paramazdo);
    azdv localazdv1 = localazdv2;
    if (localazdv2 == null) {
      localazdv1 = new azdv();
    }
    localazdv1.jdField_a_of_type_Int = paramInt1;
    localazdv1.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_JavaUtilMap.put(paramazdo, localazdv1);
  }
  
  public void a(azdo paramazdo, long paramLong1, long paramLong2)
  {
    azdv localazdv2 = (azdv)this.jdField_a_of_type_JavaUtilMap.get(paramazdo);
    azdv localazdv1 = localazdv2;
    if (localazdv2 == null) {
      localazdv1 = new azdv();
    }
    localazdv1.h = paramLong1;
    localazdv1.i = paramLong2;
    this.jdField_a_of_type_JavaUtilMap.put(paramazdo, localazdv1);
  }
  
  public void a(azdo paramazdo, String paramString1, String paramString2, String paramString3)
  {
    azdv localazdv2 = (azdv)this.jdField_a_of_type_JavaUtilMap.get(paramazdo);
    azdv localazdv1 = localazdv2;
    if (localazdv2 == null) {
      localazdv1 = new azdv();
    }
    localazdv1.g = System.currentTimeMillis();
    localazdv1.jdField_a_of_type_JavaLangString = paramString1;
    localazdv1.jdField_b_of_type_JavaLangString = paramString2;
    localazdv1.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_a_of_type_JavaUtilMap.put(paramazdo, localazdv1);
  }
  
  public void a(azds paramazds)
  {
    this.jdField_a_of_type_Azds = paramazds;
  }
  
  public void a(String paramString1, String paramString2)
  {
    File localFile = new File(paramString2);
    if ((localFile.exists()) && (localFile.length() > 0L) && (!this.b.containsKey(paramString1)))
    {
      azeu.a("VoiceTimeTraceUtil", "put snapshot key: " + paramString1 + ", path: " + paramString2);
      this.b.put(paramString1, paramString2);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3) {}
  
  public void b()
  {
    Iterator localIterator = this.b.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (!((String)localEntry.getKey()).equalsIgnoreCase("SLK")) {
        FileUtils.deleteFile((String)localEntry.getValue());
      }
    }
    this.b.clear();
  }
  
  public void b(azdo paramazdo)
  {
    azdv localazdv2 = (azdv)this.jdField_a_of_type_JavaUtilMap.get(paramazdo);
    azdv localazdv1 = localazdv2;
    if (localazdv2 == null) {
      localazdv1 = new azdv();
    }
    localazdv1.jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_JavaUtilMap.put(paramazdo, localazdv1);
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
  
  public void c(azdo paramazdo)
  {
    azdv localazdv2 = (azdv)this.jdField_a_of_type_JavaUtilMap.get(paramazdo);
    azdv localazdv1 = localazdv2;
    if (localazdv2 == null) {
      localazdv1 = new azdv();
    }
    localazdv1.jdField_c_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_JavaUtilMap.put(paramazdo, localazdv1);
  }
  
  public void d()
  {
    azfg localazfg = (azfg)azeu.a().getManager(387);
    if ((localazfg != null) && (localazfg.a() != null))
    {
      a(localazfg.a());
      return;
    }
    azeu.a("VoiceTimeTraceUtil", "traceSnapshot, env Error");
  }
  
  public void d(azdo paramazdo)
  {
    azdv localazdv2 = (azdv)this.jdField_a_of_type_JavaUtilMap.get(paramazdo);
    azdv localazdv1 = localazdv2;
    if (localazdv2 == null) {
      localazdv1 = new azdv();
    }
    localazdv1.d = System.currentTimeMillis();
    this.jdField_a_of_type_JavaUtilMap.put(paramazdo, localazdv1);
  }
  
  public void e(azdo paramazdo)
  {
    azdv localazdv2 = (azdv)this.jdField_a_of_type_JavaUtilMap.get(paramazdo);
    azdv localazdv1 = localazdv2;
    if (localazdv2 == null) {
      localazdv1 = new azdv();
    }
    localazdv1.e = System.currentTimeMillis();
    this.jdField_a_of_type_JavaUtilMap.put(paramazdo, localazdv1);
  }
  
  public void f(azdo paramazdo)
  {
    azdv localazdv2 = (azdv)this.jdField_a_of_type_JavaUtilMap.get(paramazdo);
    azdv localazdv1 = localazdv2;
    if (localazdv2 == null) {
      localazdv1 = new azdv();
    }
    localazdv1.f = System.currentTimeMillis();
    this.jdField_a_of_type_JavaUtilMap.put(paramazdo, localazdv1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azdw
 * JD-Core Version:    0.7.0.1
 */