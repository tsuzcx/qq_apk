import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.data.CaptureTemplateManager.1;
import dov.com.qq.im.capture.data.CaptureTemplateManager.2;
import dov.com.qq.im.capture.data.TemplateData;
import dov.com.qq.im.capture.part.QIMTemplateItem;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bhhb
  extends bhfe
{
  public static final File a;
  public static final String a;
  public static final String b;
  public static final String c;
  public Bitmap a;
  private bhhd jdField_a_of_type_Bhhd;
  public bhhr a;
  CopyOnWriteArrayList<TemplateData> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  private boolean jdField_a_of_type_Boolean;
  public bhhr[] a;
  public QIMTemplateItem[] a;
  String d;
  
  static
  {
    jdField_a_of_type_JavaLangString = ajed.aU + "capture_template" + File.separator;
    b = jdField_a_of_type_JavaLangString + "resource" + File.separator;
    c = jdField_a_of_type_JavaLangString + "capture_res" + File.separator;
    int i = 0;
    try
    {
      boolean bool = "mounted".equals(Environment.getExternalStorageState());
      i = bool;
    }
    catch (Exception localException)
    {
      label103:
      File localFile;
      break label103;
    }
    if (i != 0) {}
    for (localFile = new File(ajed.aU);; localFile = BaseApplicationImpl.getApplication().getCacheDir())
    {
      jdField_a_of_type_JavaIoFile = new File(localFile, "capture_template");
      return;
    }
  }
  
  public bhhb()
  {
    this.jdField_a_of_type_ArrayOfDovComQqImCapturePartQIMTemplateItem = new QIMTemplateItem[5];
    this.jdField_a_of_type_ArrayOfBhhr = new bhhr[5];
  }
  
  private static String a(Context paramContext)
  {
    try
    {
      File localFile = new File(jdField_a_of_type_JavaLangString + "template_config.xml");
      mjg.a("CaptureTemplateManager", "getQQShortVideoFilterConfig:" + jdField_a_of_type_JavaLangString + "template_config.xml" + "|" + localFile.exists());
      if (localFile.exists()) {
        return bace.b(localFile);
      }
      baig.af(paramContext, BaseApplicationImpl.getApplication().getRuntime().getAccount(), 0);
      return null;
    }
    catch (IOException paramContext)
    {
      urk.e("CaptureTemplateManager", paramContext.toString());
    }
    return null;
  }
  
  public static void a(String paramString)
  {
    boolean bool = true;
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CaptureTemplateManager", 2, "updateTemplateConfig error: " + paramString);
      }
      return;
    }
    for (;;)
    {
      try
      {
        if (new JSONObject(paramString).optInt("showQAEntrance") != 1) {
          continue;
        }
        spz.g(bool);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        continue;
      }
      bace.a(jdField_a_of_type_JavaLangString, "template_config.xml", paramString);
      return;
      bool = false;
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    ThreadManager.excute(new CaptureTemplateManager.2(this, paramString2, paramString4, paramString1), 128, null, true);
  }
  
  public static boolean a()
  {
    boolean bool = new File(jdField_a_of_type_JavaLangString + "template_config.xml").exists();
    if (QLog.isColorLevel()) {
      QLog.d("CaptureTemplateManager", 1, "getQQShortVideoFilterConfig:" + jdField_a_of_type_JavaLangString + "template_config.xml" + "|" + bool);
    }
    return bool;
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    paramString1 = new File(paramString1);
    if (!paramString1.exists()) {}
    do
    {
      for (;;)
      {
        return false;
        try
        {
          paramString1 = bace.c(paramString1.getPath());
          if ((!TextUtils.isEmpty(paramString1)) && (paramString1.equalsIgnoreCase(paramString2))) {
            return true;
          }
        }
        catch (UnsatisfiedLinkError paramString1) {}
      }
    } while (!QLog.isColorLevel());
    paramString1.printStackTrace();
    return false;
  }
  
  private void b(String paramString)
  {
    paramString = new File(paramString);
    if (paramString.exists()) {
      paramString.delete();
    }
  }
  
  public static void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CaptureTemplateManager", 2, "deleteTemplateConfig");
    }
    File localFile = new File(jdField_a_of_type_JavaLangString + "template_config.xml");
    if (localFile.exists()) {
      localFile.delete();
    }
  }
  
  private void f()
  {
    label17:
    Iterator localIterator;
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) || (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() <= 0)) {
      return;
    } else {
      localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label17;
      }
      Object localObject = (TemplateData)localIterator.next();
      if ((((TemplateData)localObject).jdField_a_of_type_JavaUtilList == null) || (((TemplateData)localObject).jdField_a_of_type_JavaUtilList.size() <= 0)) {
        break;
      }
      String str = ((TemplateData)localObject).b;
      localObject = ((TemplateData)localObject).jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        QIMTemplateItem localQIMTemplateItem = (QIMTemplateItem)((Iterator)localObject).next();
        if ((localQIMTemplateItem.jdField_a_of_type_JavaLangString.equals(str)) && (!a(localQIMTemplateItem.j, localQIMTemplateItem.i)) && (!TextUtils.isEmpty(localQIMTemplateItem.h))) {
          a(localQIMTemplateItem.h, localQIMTemplateItem.j, localQIMTemplateItem.jdField_a_of_type_JavaLangString, localQIMTemplateItem.i);
        }
      }
    }
  }
  
  public Bitmap a()
  {
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public final bhhr a()
  {
    return this.jdField_a_of_type_Bhhr;
  }
  
  public QIMTemplateItem a(int paramInt)
  {
    return this.jdField_a_of_type_ArrayOfDovComQqImCapturePartQIMTemplateItem[paramInt];
  }
  
  public CopyOnWriteArrayList<TemplateData> a(String paramString)
  {
    CopyOnWriteArrayList localCopyOnWriteArrayList = new CopyOnWriteArrayList();
    paramString = new JSONObject(paramString).getJSONArray("categorys");
    ArrayList localArrayList = new ArrayList(paramString.length());
    int i = 0;
    while (i < paramString.length())
    {
      localArrayList.add(new TemplateData(paramString.getJSONObject(i)));
      i += 1;
    }
    localCopyOnWriteArrayList.clear();
    localCopyOnWriteArrayList.addAll(localArrayList);
    ((bhgs)bhfm.a(5)).c();
    a(localArrayList);
    return localCopyOnWriteArrayList;
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
  
  public void a(bhhr parambhhr)
  {
    this.jdField_a_of_type_Bhhr = parambhhr;
  }
  
  public void a(bhhr parambhhr, Activity paramActivity, int paramInt)
  {
    if (paramInt == 0)
    {
      if (this.jdField_a_of_type_ArrayOfDovComQqImCapturePartQIMTemplateItem[2] != null) {}
      this.jdField_a_of_type_ArrayOfBhhr[2] = parambhhr;
      if (this.jdField_a_of_type_ArrayOfBhhr[1] != null) {}
      this.jdField_a_of_type_ArrayOfBhhr[1] = parambhhr;
    }
    while (paramInt == -1)
    {
      return;
      if ((paramInt == 2) || (paramInt == 1) || (paramInt == 3) || (paramInt != 4)) {}
    }
    this.jdField_a_of_type_ArrayOfBhhr[paramInt] = parambhhr;
  }
  
  public void a(QIMTemplateItem paramQIMTemplateItem, Activity paramActivity, int paramInt)
  {
    bhgs localbhgs = (bhgs)bhfm.a(5);
    if (paramInt == 0)
    {
      if (this.jdField_a_of_type_ArrayOfDovComQqImCapturePartQIMTemplateItem[2] != null) {}
      this.jdField_a_of_type_ArrayOfDovComQqImCapturePartQIMTemplateItem[2] = paramQIMTemplateItem;
      if (this.jdField_a_of_type_ArrayOfDovComQqImCapturePartQIMTemplateItem[1] != null) {}
      this.jdField_a_of_type_ArrayOfDovComQqImCapturePartQIMTemplateItem[1] = paramQIMTemplateItem;
    }
    while (paramInt == -1)
    {
      return;
      if ((paramInt == 2) || (paramInt == 1) || (paramInt == 3) || (paramInt != 4)) {}
    }
    QIMTemplateItem localQIMTemplateItem = this.jdField_a_of_type_ArrayOfDovComQqImCapturePartQIMTemplateItem[paramInt];
    paramActivity = paramQIMTemplateItem;
    if (localQIMTemplateItem != null)
    {
      localbhgs.a(localQIMTemplateItem);
      if (paramQIMTemplateItem != null) {
        break label176;
      }
      paramActivity = paramQIMTemplateItem;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QCombo", 2, "setSelectedTemplate last:" + localQIMTemplateItem + " new:" + paramActivity + ", " + paramInt);
      }
      this.jdField_a_of_type_ArrayOfDovComQqImCapturePartQIMTemplateItem[paramInt] = paramActivity;
      if ((paramActivity == null) || (paramActivity.a())) {
        break;
      }
      return;
      label176:
      paramActivity = paramQIMTemplateItem;
      if (TextUtils.equals(localQIMTemplateItem.jdField_a_of_type_JavaLangString, paramQIMTemplateItem.jdField_a_of_type_JavaLangString)) {
        paramActivity = localQIMTemplateItem;
      }
    }
  }
  
  public boolean a(Context paramContext)
  {
    bool2 = false;
    paramContext = a(paramContext);
    bool1 = bool2;
    try
    {
      if (!TextUtils.isEmpty(paramContext))
      {
        this.d = paramContext;
        this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = a(paramContext);
        boolean bool3 = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.isEmpty();
        bool1 = bool2;
        if (!bool3) {
          bool1 = true;
        }
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        urk.c("CaptureTemplateManager", "initFromCache", paramContext);
        bool1 = bool2;
      }
    }
    urk.b("CaptureTemplateManager", "initFromCache " + bool1);
    return bool1;
  }
  
  public boolean a(bhhr parambhhr, int paramInt)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    if (parambhhr != null)
    {
      bhhr localbhhr = this.jdField_a_of_type_ArrayOfBhhr[paramInt];
      boolean bool1 = bool3;
      if (localbhhr != null)
      {
        bool1 = bool3;
        if (parambhhr.b().equals(localbhhr.b())) {
          bool1 = true;
        }
      }
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("QCombo", 2, "isApplying :" + parambhhr);
        bool2 = bool1;
      }
    }
    return bool2;
  }
  
  public boolean a(List<TemplateData> paramList)
  {
    urk.b("CaptureTemplateManager", "preInitCombo: " + paramList.size());
    bhgs localbhgs = (bhgs)bhfm.a(5);
    paramList = paramList.iterator();
    boolean bool = false;
    if (paramList.hasNext())
    {
      TemplateData localTemplateData = (TemplateData)paramList.next();
      if (localTemplateData.jdField_a_of_type_JavaUtilList == null) {
        break label244;
      }
      Iterator localIterator = localTemplateData.jdField_a_of_type_JavaUtilList.iterator();
      if (localIterator.hasNext())
      {
        QIMTemplateItem localQIMTemplateItem = (QIMTemplateItem)localIterator.next();
        bhhr localbhhr;
        if (localTemplateData.jdField_a_of_type_Boolean)
        {
          localbhhr = localbhgs.a(localQIMTemplateItem);
          localbhhr.a = localbhhr.a();
          if (localbhhr.a == 1)
          {
            localbhhr.b = ((int)(10000.0F * localbhhr.a()));
            urk.b("CaptureTemplateManager", "preInitCombo progress: " + localQIMTemplateItem.b + ", progress: " + localbhhr.b);
            bool = true;
          }
        }
        for (;;)
        {
          break;
          if (localbhhr.a != 2) {
            if (localbhhr.a == 3) {
              localbhhr.b = 10000;
            }
          }
        }
      }
    }
    label244:
    for (;;)
    {
      break;
      return bool;
    }
  }
  
  public void aY_()
  {
    ThreadManager.post(new CaptureTemplateManager.1(this), 8, null, true);
  }
  
  public void aZ_() {}
  
  public void c()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    d();
  }
  
  public void d()
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList == null) || (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() <= 0)) {
      a(BaseApplicationImpl.sApplication);
    }
    f();
    if (this.jdField_a_of_type_Bhhd != null) {
      this.jdField_a_of_type_Bhhd.a(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhhb
 * JD-Core Version:    0.7.0.1
 */