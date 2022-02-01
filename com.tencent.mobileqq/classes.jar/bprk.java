import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.predownload.QIMPredownHistory;
import dov.com.qq.im.capture.predownload.QIMResClickHistory;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.app.AppRuntime;

public class bprk
  extends bpli
  implements Handler.Callback, bprj
{
  static File jdField_a_of_type_JavaIoFile;
  public static final String[] a;
  public Handler a;
  public bpri a;
  bprl jdField_a_of_type_Bprl;
  ArrayList<bprm> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  LinkedList<bpri> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  public boolean a;
  ArrayList<bprm> b;
  public boolean b;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "combo", "filter", "music", "ptv", "paster", "text" };
  }
  
  public bprk()
  {
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  }
  
  private bpri a(int paramInt1, String paramString, int paramInt2)
  {
    bpri localbpri = new bpri();
    localbpri.jdField_a_of_type_Int = paramInt1;
    localbpri.jdField_a_of_type_JavaLangString = paramString;
    localbpri.b = paramInt2;
    localbpri.a(this);
    return localbpri;
  }
  
  public static File a()
  {
    if (jdField_a_of_type_JavaIoFile == null)
    {
      jdField_a_of_type_JavaIoFile = new File(BaseApplicationImpl.getContext().getFilesDir(), "predownload");
      jdField_a_of_type_JavaIoFile.mkdir();
    }
    return jdField_a_of_type_JavaIoFile;
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMPredownManager", 2, "content " + paramString);
    }
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        bprl localbprl = bprl.a(paramString);
        File localFile = new File(a(), "predownload11111.cfg");
        SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("qim_pre_down11111", 0).edit();
        if (localEditor != null) {
          localEditor.remove("leftRaw").apply();
        }
        bhmi.a(localFile.getAbsolutePath(), paramString);
        a(localbprl);
        d();
        return;
      }
      catch (Exception paramString)
      {
        while (!QLog.isColorLevel()) {}
        QLog.i("QIMPredownManager", 2, "config  ", paramString);
        return;
      }
    }
    new File(a(), "predownload11111.cfg").delete();
  }
  
  private void e()
  {
    c();
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.jdField_b_of_type_JavaUtilArrayList);
    if (QLog.isColorLevel()) {
      QLog.i("QIMPredownManager", 2, String.format("startPredown level:%d  queue:%d  left:%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Bprl.jdField_a_of_type_Int), Integer.valueOf(this.jdField_a_of_type_JavaUtilLinkedList.size()), Integer.valueOf(this.jdField_b_of_type_JavaUtilArrayList.size()) }));
    }
    int k = localArrayList.size();
    int j = 0;
    int i = 0;
    if ((j >= k) || (this.jdField_a_of_type_JavaUtilLinkedList.size() >= 30))
    {
      if (i != 0) {
        d();
      }
      if (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty())
      {
        if (QLog.isColorLevel()) {
          QLog.i("QIMPredownManager", 2, String.format("startPredown: %d", new Object[] { Integer.valueOf(this.jdField_a_of_type_JavaUtilLinkedList.size()) }));
        }
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
      }
      return;
    }
    bprm localbprm = (bprm)localArrayList.get(j);
    bpri localbpri;
    if (this.jdField_a_of_type_Bprl.jdField_a_of_type_Int >= localbprm.b)
    {
      localbpri = a(localbprm.jdField_a_of_type_Int, localbprm.jdField_a_of_type_JavaLangString, localbprm.c);
      switch (localbpri.a())
      {
      }
    }
    for (;;)
    {
      j += 1;
      break;
      this.jdField_b_of_type_JavaUtilArrayList.remove(localbprm);
      this.jdField_a_of_type_JavaUtilLinkedList.offer(localbpri);
      continue;
      this.jdField_a_of_type_JavaUtilArrayList.remove(localbprm);
      this.jdField_b_of_type_JavaUtilArrayList.remove(localbprm);
      i = 1;
    }
  }
  
  public void a() {}
  
  public void a(bprl parambprl)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilLinkedList.clear();
    this.jdField_a_of_type_Bprl = parambprl;
    Object localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("qim_pre_down11111", 0).getString("leftRaw", null);
    if (QLog.isColorLevel()) {
      QLog.i("QIMPredownManager", 2, "updateData leftRaw: " + (String)localObject1);
    }
    if (localObject1 == null)
    {
      parambprl = parambprl.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (parambprl.hasNext())
      {
        localObject1 = (bprm)parambprl.next();
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
        this.jdField_b_of_type_JavaUtilArrayList.add(localObject1);
      }
    }
    localObject1 = ((String)localObject1).split(":");
    int j = localObject1.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        Object localObject2 = localObject1[i];
        try
        {
          int k = Integer.valueOf((String)localObject2).intValue();
          localObject2 = parambprl.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            bprm localbprm = (bprm)((Iterator)localObject2).next();
            if (localbprm.jdField_a_of_type_Int == k)
            {
              this.jdField_a_of_type_JavaUtilArrayList.add(localbprm);
              this.jdField_b_of_type_JavaUtilArrayList.add(localbprm);
            }
          }
        }
        catch (Exception localException)
        {
          i += 1;
        }
      }
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("type", Integer.valueOf(paramInt));
    localHashMap.put("id", paramString);
    Message.obtain(this.jdField_a_of_type_AndroidOsHandler, 3, localHashMap).sendToTarget();
  }
  
  public void a(boolean paramBoolean, bpri parambpri)
  {
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      parambpri = Message.obtain(localHandler, 2, i, 0, parambpri);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(parambpri, 3000L);
      return;
    }
  }
  
  public boolean a()
  {
    boolean bool2 = this.jdField_b_of_type_Boolean;
    boolean bool3 = AppNetConnInfo.isWifiConn();
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
    if ((localAppRuntime != null) && (localAppRuntime.isLogin())) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QIMPredownManager", 2, "canPredownload bg " + bool2 + " wifi " + bool3 + " log " + bool1);
      }
      if ((!bool2) || (!bool1) || (!bool3)) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public void b() {}
  
  public void c()
  {
    if (this.jdField_a_of_type_Bprl != null) {
      return;
    }
    localObject4 = new File(a(), "predownload11111.cfg");
    Object localObject2 = null;
    Object localObject1 = localObject2;
    try
    {
      localObject4 = bhmi.a((File)localObject4);
      localObject1 = localObject2;
      localObject2 = bprl.a((String)localObject4);
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        localObject1 = localObject2;
        QLog.i("QIMPredownManager", 2, "ensureInit cache " + (String)localObject4);
      }
      localObject1 = localObject2;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("QIMPredownManager", 2, "ensureInit: ", localException2);
        }
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject4 = localObject1;
    }
    try
    {
      String str = bpup.a("predownload11111.cfg");
      localObject4 = localObject1;
      localObject1 = bprl.a(str);
      localObject2 = localObject1;
      localObject4 = localObject1;
      if (QLog.isColorLevel())
      {
        localObject4 = localObject1;
        QLog.i("QIMPredownManager", 2, "ensureInit asset " + str);
        localObject2 = localObject1;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        Object localObject3 = localObject4;
        if (QLog.isColorLevel())
        {
          QLog.i("QIMPredownManager", 2, "ensureInit: ", localException1);
          localObject3 = localObject4;
        }
      }
    }
    this.jdField_a_of_type_Boolean = true;
    a((bprl)localObject2);
  }
  
  public void d()
  {
    Object localObject = new StringBuilder(this.jdField_a_of_type_JavaUtilArrayList.size());
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      bprm localbprm = (bprm)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (i == 0) {
        ((StringBuilder)localObject).append(localbprm.jdField_a_of_type_Int);
      }
      for (;;)
      {
        i += 1;
        break;
        ((StringBuilder)localObject).append(":");
        ((StringBuilder)localObject).append(localbprm.jdField_a_of_type_Int);
      }
    }
    localObject = ((StringBuilder)localObject).toString();
    BaseApplicationImpl.getApplication().getSharedPreferences("qim_pre_down11111", 0).edit().putString("leftRaw", (String)localObject).apply();
    if (QLog.isColorLevel()) {
      QLog.i("QIMPredownManager", 2, "saveWaitingQueue leftRaw: " + (String)localObject);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    Object localObject3;
    int i;
    label300:
    label366:
    do
    {
      for (;;)
      {
        return false;
        e();
        continue;
        if (QLog.isColorLevel()) {
          QLog.i("QIMPredownManager", 2, "checkAndCreateJob: MSG_CHECK_ANDROID_CREATE_EXECUTE");
        }
        if (paramMessage.obj != null)
        {
          localObject1 = (bpri)paramMessage.obj;
          if (QLog.isColorLevel()) {
            QLog.i("QIMPredownManager", 2, "onJobFinish: " + ((bpri)localObject1).jdField_a_of_type_Int + ", " + ((bpri)localObject1).jdField_a_of_type_JavaLangString);
          }
          localObject2 = new QIMPredownHistory();
          ((QIMPredownHistory)localObject2).resId = ((bpri)localObject1).jdField_a_of_type_JavaLangString;
          ((QIMPredownHistory)localObject2).resType = jdField_a_of_type_ArrayOfJavaLangString[localObject1.b];
          localObject3 = a().getEntityManagerFactory().createEntityManager();
          ((EntityManager)localObject3).persist((Entity)localObject2);
          ((EntityManager)localObject3).close();
          if (paramMessage.arg1 == 1)
          {
            i = 0;
            if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
            {
              paramMessage = (bprm)this.jdField_a_of_type_JavaUtilArrayList.get(i);
              if (paramMessage.jdField_a_of_type_Int != ((bpri)localObject1).jdField_a_of_type_Int) {
                break label366;
              }
              if (QLog.isColorLevel()) {
                QLog.i("QIMPredownManager", 2, "onJobFinish: remove " + ((bpri)localObject1).jdField_a_of_type_Int + ", " + ((bpri)localObject1).jdField_a_of_type_JavaLangString);
              }
              this.jdField_a_of_type_JavaUtilArrayList.remove(paramMessage);
              d();
            }
          }
        }
        if (a())
        {
          i = 1;
          if (i != 0)
          {
            paramMessage = (bpri)this.jdField_a_of_type_JavaUtilLinkedList.poll();
            if (paramMessage != null)
            {
              switch (paramMessage.a())
              {
              case 1: 
              default: 
                if (QLog.isColorLevel()) {
                  QLog.i("QIMPredownManager", 2, "runJob ignore");
                }
                break;
              }
              for (;;)
              {
                break label300;
                i += 1;
                break;
                this.jdField_a_of_type_Bpri = paramMessage;
                paramMessage.a();
                i = 0;
                continue;
                this.jdField_a_of_type_Bpri = paramMessage;
                a(true, paramMessage);
                i = 0;
              }
            }
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.i("QIMPredownManager", 2, "runJob aborted");
          continue;
          a((String)paramMessage.obj);
        }
      }
      localObject3 = this.jdField_a_of_type_Bprl;
    } while (localObject3 == null);
    paramMessage = (HashMap)paramMessage.obj;
    Object localObject1 = (String)paramMessage.get("id");
    int m = ((Integer)paramMessage.get("type")).intValue();
    paramMessage = a().getEntityManagerFactory().createEntityManager();
    Object localObject2 = paramMessage.query(QIMResClickHistory.class, true, "resId=? and resType=?", new String[] { localObject1, jdField_a_of_type_ArrayOfJavaLangString[m] }, null, null, null, null);
    paramMessage.close();
    int j;
    if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
    {
      j = 1;
      label548:
      if (j == 0)
      {
        localObject2 = new QIMResClickHistory();
        ((QIMResClickHistory)localObject2).resId = ((String)localObject1);
        ((QIMResClickHistory)localObject2).resType = jdField_a_of_type_ArrayOfJavaLangString[m];
        paramMessage = a().getEntityManagerFactory().createEntityManager();
        paramMessage.persist((Entity)localObject2);
        paramMessage.close();
      }
      paramMessage = paramMessage.query(QIMPredownHistory.class, true, "resId=? and resType=?", new String[] { localObject1, jdField_a_of_type_ArrayOfJavaLangString[m] }, null, null, null, null);
      if ((paramMessage == null) || (paramMessage.isEmpty())) {
        break label872;
      }
      i = 1;
      label649:
      localObject2 = new bdnt();
      ((bdnt)localObject2).d = "0X80090DF";
      ((bdnt)localObject2).f = String.valueOf(m);
      ((bdnt)localObject2).h = ((String)localObject1);
      ((bdnt)localObject2).i = String.valueOf(bhsi.A(BaseApplicationImpl.context));
      if (j == 0) {
        break label877;
      }
      paramMessage = "2";
      label705:
      ((bdnt)localObject2).j = paramMessage;
      int k = -1;
      paramMessage = ((bprl)localObject3).jdField_b_of_type_JavaUtilArrayList.iterator();
      do
      {
        j = k;
        if (!paramMessage.hasNext()) {
          break;
        }
        localObject3 = (bprm)paramMessage.next();
      } while ((!TextUtils.equals((CharSequence)localObject1, ((bprm)localObject3).jdField_a_of_type_JavaLangString)) || (m != ((bprm)localObject3).c));
      j = ((bprm)localObject3).b;
      if ((j == -1) && (i == 0)) {
        break label884;
      }
      paramMessage = "1";
      label788:
      ((bdnt)localObject2).k = paramMessage;
      paramMessage = new bpri();
      paramMessage.jdField_a_of_type_JavaLangString = ((String)localObject1);
      paramMessage.b = m;
      i = 0;
      paramMessage = paramMessage.a();
      if (paramMessage != null)
      {
        if (paramMessage.a() != 3) {
          break label891;
        }
        i = 1;
      }
      label835:
      if (i == 0) {
        break label896;
      }
    }
    label896:
    for (paramMessage = "1";; paramMessage = "2")
    {
      ((bdnt)localObject2).l = paramMessage;
      ((bdnt)localObject2).m = String.valueOf(j);
      bdlh.a(null, (bdnt)localObject2);
      break;
      j = 0;
      break label548;
      label872:
      i = 0;
      break label649;
      label877:
      paramMessage = "1";
      break label705;
      label884:
      paramMessage = "2";
      break label788;
      label891:
      i = 0;
      break label835;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bprk
 * JD-Core Version:    0.7.0.1
 */