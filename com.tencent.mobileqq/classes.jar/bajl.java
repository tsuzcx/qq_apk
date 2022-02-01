import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
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

public class bajl
{
  private volatile bajh jdField_a_of_type_Bajh;
  private Map<bajd, bajk> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  private Map<String, String> b = new ConcurrentHashMap();
  
  public static bajl a()
  {
    return bajm.a();
  }
  
  private String a(int paramInt)
  {
    String str2 = String.valueOf(paramInt).trim();
    String str1;
    if (str2.startsWith("0")) {
      str1 = "请求成功-" + str2;
    }
    do
    {
      return str1;
      if (str2.startsWith("3010")) {
        return "参数非法-" + str2;
      }
      if (str2.startsWith("3020")) {
        return "不支持类型或VoiceId非法-" + str2;
      }
      if (str2.startsWith("3030")) {
        return "语音包太大或空片-" + str2;
      }
      if (str2.startsWith("3040")) {
        return "解压缩失败-" + str2;
      }
      if (str2.startsWith("3050")) {
        return "资源不足拒绝服务-" + str2;
      }
      str1 = str2;
    } while (!str2.startsWith("3060"));
    return "引擎内部失败-" + str2;
  }
  
  private String b(int paramInt)
  {
    String str2 = String.valueOf(paramInt).trim();
    String str1;
    if (str2.startsWith("0")) {
      str1 = "请求成功-" + str2;
    }
    do
    {
      return str1;
      if (str2.startsWith("100")) {
        return "后台失败-" + str2;
      }
      if (str2.startsWith("101")) {
        return "微信消息体为空-" + str2;
      }
      if (str2.startsWith("102")) {
        return "微信错误-" + str2;
      }
      str1 = str2;
    } while (!str2.startsWith("103"));
    return "参数错误-" + str2;
  }
  
  public String a(String paramString)
  {
    if ((this.jdField_a_of_type_Bajh == null) || (this.jdField_a_of_type_Bajh.a())) {
      return "";
    }
    ArrayList localArrayList = new ArrayList();
    paramString = bakl.a(paramString);
    int i = 0;
    while (i < this.jdField_a_of_type_Bajh.a())
    {
      localObject = this.jdField_a_of_type_Bajh.a(i);
      if ((((bajd)localObject).b()) && (((bajd)localObject).jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramString))) {
        localArrayList.add(this.jdField_a_of_type_JavaUtilMap.get(localObject));
      }
      i += 1;
    }
    if (localArrayList.isEmpty())
    {
      bakl.a("VoiceTimeTraceUtil", "summaryTraceInfo, traceInfoList empty, cacheSize:" + this.jdField_a_of_type_Bajh.a());
      return "";
    }
    paramString = localArrayList.iterator();
    for (long l1 = 0L; paramString.hasNext(); l1 = ((bajk)localObject).j + l1)
    {
      localObject = (bajk)paramString.next();
      ((bajk)localObject).a();
    }
    l1 /= localArrayList.size();
    paramString = (bajk)localArrayList.get(localArrayList.size() - 1);
    Object localObject = (bajk)localArrayList.get(0);
    long l2 = paramString.g - ((bajk)localObject).jdField_a_of_type_Long;
    localObject = new StringBuilder("\n");
    ((StringBuilder)localObject).append("指令总耗时：").append(l2).append("\n");
    ((StringBuilder)localObject).append("指令分片数：").append(localArrayList.size()).append("\n");
    ((StringBuilder)localObject).append("分片平均耗时：").append(l1).append("\n");
    ((StringBuilder)localObject).append("ASR耗时：").append(paramString.h).append("\n");
    ((StringBuilder)localObject).append("NLP耗时：").append(paramString.i).append("\n");
    ((StringBuilder)localObject).append("尾分片总耗时：").append(paramString.j).append("\n");
    ((StringBuilder)localObject).append("尾包本地耗时：").append(paramString.k).append("\n");
    ((StringBuilder)localObject).append("尾包网络耗时：").append(paramString.l).append("\n");
    bakl.a("VoiceTimeTraceUtil", ((StringBuilder)localObject).toString().replace("\n", "， "));
    StringBuilder localStringBuilder = new StringBuilder("\n");
    localStringBuilder.append("语音指令ID：").append(paramString.jdField_a_of_type_JavaLangString).append("\n");
    localStringBuilder.append("后台错误码：").append(b(paramString.jdField_a_of_type_Int)).append("\n");
    localStringBuilder.append("微信错误码：").append(a(paramString.jdField_b_of_type_Int)).append("\n");
    localStringBuilder.append("语音转文本：").append(paramString.jdField_b_of_type_JavaLangString).append("\n");
    localStringBuilder.append("技能树意图：").append(paramString.jdField_c_of_type_JavaLangString).append("\n");
    bakl.a("VoiceTimeTraceUtil", localStringBuilder.toString().replace("\n", "， "));
    bakl.a(paramString.a(), paramString.jdField_a_of_type_JavaLangString, paramString.jdField_b_of_type_JavaLangString, paramString.jdField_c_of_type_JavaLangString, localArrayList.size(), paramString.jdField_d_of_type_Int, l2, l1, paramString.h, paramString.i, paramString.j, paramString.k, paramString.l);
    return localStringBuilder.toString().trim() + "\n" + ((StringBuilder)localObject).toString().trim();
  }
  
  public void a() {}
  
  public void a(Activity paramActivity)
  {
    if ((!balw.a()) || (paramActivity == null))
    {
      QQToast.a(paramActivity, "转发环境错误", 0).a();
      return;
    }
    Object localObject = (bakx)bakl.a().getManager(QQManagerFactory.VOICE_ASSISTANT_MANAGER);
    if ((localObject != null) && (((bakx)localObject).c())) {
      ((bakx)localObject).a(true, false);
    }
    bakl.a("VoiceTimeTraceUtil", "snapshotList:" + this.b.toString());
    if (this.b.isEmpty())
    {
      QQToast.a(paramActivity, "快照文件为空", 0).a();
      return;
    }
    if (((this.b.get("SLK") == null) || (!FileUtils.isEmptyFile((String)this.b.get("SLK")))) || (((this.b.get("PCM") == null) || (!FileUtils.isEmptyFile((String)this.b.get("PCM")))) || ((this.b.get("BUF") != null) && (FileUtils.isEmptyFile((String)this.b.get("BUF")))))) {}
    localObject = new ArrayList(this.b.values().size());
    ThreadManager.getFileThreadHandler().post(new VoiceTimeTraceUtil.1(this, (List)localObject, paramActivity));
  }
  
  public void a(bajd parambajd)
  {
    bajk localbajk2 = (bajk)this.jdField_a_of_type_JavaUtilMap.get(parambajd);
    bajk localbajk1 = localbajk2;
    if (localbajk2 == null) {
      localbajk1 = new bajk();
    }
    localbajk1.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_JavaUtilMap.put(parambajd, localbajk1);
  }
  
  public void a(bajd parambajd, int paramInt1, int paramInt2, int paramInt3)
  {
    bajk localbajk2 = (bajk)this.jdField_a_of_type_JavaUtilMap.get(parambajd);
    bajk localbajk1 = localbajk2;
    if (localbajk2 == null) {
      localbajk1 = new bajk();
    }
    localbajk1.jdField_a_of_type_Int = paramInt1;
    localbajk1.jdField_b_of_type_Int = paramInt2;
    localbajk1.jdField_c_of_type_Int = paramInt3;
    this.jdField_a_of_type_JavaUtilMap.put(parambajd, localbajk1);
  }
  
  public void a(bajd parambajd, long paramLong1, long paramLong2)
  {
    bajk localbajk2 = (bajk)this.jdField_a_of_type_JavaUtilMap.get(parambajd);
    bajk localbajk1 = localbajk2;
    if (localbajk2 == null) {
      localbajk1 = new bajk();
    }
    localbajk1.h = paramLong1;
    localbajk1.i = paramLong2;
    this.jdField_a_of_type_JavaUtilMap.put(parambajd, localbajk1);
  }
  
  public void a(bajd parambajd, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    bajk localbajk2 = (bajk)this.jdField_a_of_type_JavaUtilMap.get(parambajd);
    bajk localbajk1 = localbajk2;
    if (localbajk2 == null) {
      localbajk1 = new bajk();
    }
    localbajk1.g = System.currentTimeMillis();
    localbajk1.jdField_a_of_type_JavaLangString = paramString1;
    localbajk1.jdField_b_of_type_JavaLangString = paramString2;
    localbajk1.jdField_d_of_type_Int = paramInt;
    localbajk1.jdField_c_of_type_JavaLangString = paramString3;
    this.jdField_a_of_type_JavaUtilMap.put(parambajd, localbajk1);
  }
  
  public void a(bajh parambajh)
  {
    this.jdField_a_of_type_Bajh = parambajh;
  }
  
  public void a(String paramString1, String paramString2)
  {
    File localFile = new File(paramString2);
    if ((localFile.exists()) && (localFile.length() > 0L) && (!this.b.containsKey(paramString1)))
    {
      bakl.a("VoiceTimeTraceUtil", "put snapshot key: " + paramString1 + ", path: " + paramString2);
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
  
  public void b(bajd parambajd)
  {
    bajk localbajk2 = (bajk)this.jdField_a_of_type_JavaUtilMap.get(parambajd);
    bajk localbajk1 = localbajk2;
    if (localbajk2 == null) {
      localbajk1 = new bajk();
    }
    localbajk1.jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_JavaUtilMap.put(parambajd, localbajk1);
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
  
  public void c(bajd parambajd)
  {
    bajk localbajk2 = (bajk)this.jdField_a_of_type_JavaUtilMap.get(parambajd);
    bajk localbajk1 = localbajk2;
    if (localbajk2 == null) {
      localbajk1 = new bajk();
    }
    localbajk1.jdField_c_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_JavaUtilMap.put(parambajd, localbajk1);
  }
  
  public void d()
  {
    bakx localbakx = (bakx)bakl.a().getManager(QQManagerFactory.VOICE_ASSISTANT_MANAGER);
    if ((localbakx != null) && (localbakx.a() != null))
    {
      a(localbakx.a());
      return;
    }
    bakl.a("VoiceTimeTraceUtil", "traceSnapshot, env Error");
  }
  
  public void d(bajd parambajd)
  {
    bajk localbajk2 = (bajk)this.jdField_a_of_type_JavaUtilMap.get(parambajd);
    bajk localbajk1 = localbajk2;
    if (localbajk2 == null) {
      localbajk1 = new bajk();
    }
    localbajk1.jdField_d_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_JavaUtilMap.put(parambajd, localbajk1);
  }
  
  public void e(bajd parambajd)
  {
    bajk localbajk2 = (bajk)this.jdField_a_of_type_JavaUtilMap.get(parambajd);
    bajk localbajk1 = localbajk2;
    if (localbajk2 == null) {
      localbajk1 = new bajk();
    }
    localbajk1.e = System.currentTimeMillis();
    this.jdField_a_of_type_JavaUtilMap.put(parambajd, localbajk1);
  }
  
  public void f(bajd parambajd)
  {
    bajk localbajk2 = (bajk)this.jdField_a_of_type_JavaUtilMap.get(parambajd);
    bajk localbajk1 = localbajk2;
    if (localbajk2 == null) {
      localbajk1 = new bajk();
    }
    localbajk1.f = System.currentTimeMillis();
    this.jdField_a_of_type_JavaUtilMap.put(parambajd, localbajk1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bajl
 * JD-Core Version:    0.7.0.1
 */