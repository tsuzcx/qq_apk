import PersonalState.UserProfile;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureHandler;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusServlet;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import mqq.app.NewIntent;
import mqq.manager.Manager;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import protocol.KQQConfig.GetResourceReqInfo;

public class bbck
  implements bazt, Manager
{
  private static volatile WeakReference<bbck> jdField_a_of_type_JavaLangRefWeakReference;
  private static Object[] jdField_a_of_type_ArrayOfJavaLangObject = new Object[2];
  private long jdField_a_of_type_Long;
  private volatile AsyncTask<Void, Integer, Integer> jdField_a_of_type_AndroidOsAsyncTask;
  private volatile SparseArray<bazh> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private anjq jdField_a_of_type_Anjq;
  private anvc jdField_a_of_type_Anvc;
  private bazr jdField_a_of_type_Bazr;
  private bbcp jdField_a_of_type_Bbcp;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private RichStatus jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
  private ArrayList<bbch> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap<Long, UserProfile> jdField_a_of_type_JavaUtilHashMap;
  private HashSet<String> jdField_a_of_type_JavaUtilHashSet;
  private LinkedList<bbaa> jdField_a_of_type_JavaUtilLinkedList;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private long jdField_b_of_type_Long;
  private AsyncTask<Void, Void, ArrayList<UserProfile>> jdField_b_of_type_AndroidOsAsyncTask;
  private ArrayList<UserProfile> jdField_b_of_type_JavaUtilArrayList;
  private LinkedList<bazy> jdField_b_of_type_JavaUtilLinkedList;
  private long jdField_c_of_type_Long;
  private ArrayList<UserProfile> jdField_c_of_type_JavaUtilArrayList;
  private LinkedList<bbab> jdField_c_of_type_JavaUtilLinkedList;
  private long jdField_d_of_type_Long;
  private LinkedList<bbad> jdField_d_of_type_JavaUtilLinkedList;
  private LinkedList<bbac> e;
  
  private bbck(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_c_of_type_Long = a().getLong("k_update_time", 0L);
  }
  
  private int a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.xml", 2, "updateActions_Local");
    }
    if (this.jdField_a_of_type_AndroidOsAsyncTask != null) {
      return 100;
    }
    this.jdField_a_of_type_AndroidOsAsyncTask = new bbcl(this).execute(new Void[0]);
    return 100;
  }
  
  private SharedPreferences a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("rich_status", 0);
  }
  
  public static bbck a(QQAppInterface paramQQAppInterface)
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localObject != paramQQAppInterface) {
      return (bbck)((QQAppInterface)localObject).getManager(15);
    }
    if (jdField_a_of_type_JavaLangRefWeakReference != null) {}
    for (localObject = (bbck)jdField_a_of_type_JavaLangRefWeakReference.get();; localObject = null)
    {
      if (localObject == null)
      {
        paramQQAppInterface = new bbck(paramQQAppInterface);
        jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
        return paramQQAppInterface;
      }
      ((bbck)localObject).jdField_a_of_type_JavaUtilHashSet.clear();
      ((bbck)localObject).jdField_b_of_type_Long = 0L;
      ((bbck)localObject).jdField_a_of_type_Long = 0L;
      ((bbck)localObject).jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = null;
      if (((bbck)localObject).jdField_a_of_type_Anjq != null)
      {
        ((bbck)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(((bbck)localObject).jdField_a_of_type_Anjq);
        ((bbck)localObject).jdField_a_of_type_Anjq = null;
      }
      if (((bbck)localObject).jdField_a_of_type_Bbcp != null)
      {
        ((bbck)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(((bbck)localObject).jdField_a_of_type_Bbcp);
        ((bbck)localObject).jdField_a_of_type_Bbcp = null;
      }
      if (((bbck)localObject).jdField_a_of_type_Bazr != null) {
        ((bbck)localObject).jdField_a_of_type_Bazr.a();
      }
      if (((bbck)localObject).jdField_a_of_type_Anvc != null)
      {
        ((bbck)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(((bbck)localObject).jdField_a_of_type_Anvc);
        ((bbck)localObject).jdField_a_of_type_Anvc = null;
      }
      ((bbck)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      return localObject;
    }
  }
  
  private void a()
  {
    this.jdField_a_of_type_Anjq = new bbcm(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anjq);
  }
  
  private boolean a(SparseArray<bazh> paramSparseArray1, SparseArray<bazh> paramSparseArray2)
  {
    int i = 0;
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.xml", 2, "removeOldIcons(" + paramSparseArray1 + ", " + paramSparseArray2 + ")");
    }
    File localFile = bazr.a();
    boolean bool1;
    if (localFile == null)
    {
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.richstatus.xml", 2, "removeOldIcons: dir is null");
        bool1 = bool2;
      }
    }
    do
    {
      do
      {
        do
        {
          return bool1;
          if (!localFile.exists())
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.richstatus.xml", 2, "removeOldIcons: dir does not exist!");
            }
            return true;
          }
          if (localFile.canWrite()) {
            break;
          }
          bool1 = bool2;
        } while (!QLog.isColorLevel());
        QLog.d("Q.richstatus.xml", 2, "removeOldIcons: dir can not write!");
        return false;
        if (paramSparseArray1 != null) {
          break;
        }
        paramSparseArray1 = localFile.listFiles();
        j = paramSparseArray1.length;
        if (i < j)
        {
          paramSparseArray2 = paramSparseArray1[i];
          if (paramSparseArray2 == null) {}
          for (;;)
          {
            i += 1;
            break;
            if ((!paramSparseArray2.exists()) || (paramSparseArray2.delete()) || (paramSparseArray2.delete()) || (!paramSparseArray2.delete())) {}
          }
        }
        bool2 = localFile.canWrite();
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.d("Q.richstatus.xml", 2, "removeOldIcons return with " + bool2);
      return bool2;
      ArrayList localArrayList = new ArrayList();
      int j = paramSparseArray2.size();
      i = 0;
      while (i < j)
      {
        bazh localbazh1 = (bazh)paramSparseArray2.valueAt(i);
        bazh localbazh2 = (bazh)paramSparseArray1.get(localbazh1.jdField_a_of_type_Int);
        if ((localbazh2 != null) && (localbazh2.jdField_a_of_type_JavaLangString != null) && (!localbazh2.jdField_a_of_type_JavaLangString.equalsIgnoreCase(localbazh1.jdField_a_of_type_JavaLangString))) {
          localArrayList.add(localbazh2.jdField_a_of_type_Int + "_s_" + 201);
        }
        if ((localbazh2 != null) && (localbazh2.b != null) && (!localbazh2.b.equalsIgnoreCase(localbazh1.b))) {
          localArrayList.add(localbazh2.jdField_a_of_type_Int + "_s_" + 200);
        }
        i += 1;
      }
      paramSparseArray1 = localArrayList.iterator();
      while (paramSparseArray1.hasNext())
      {
        paramSparseArray2 = new File(localFile, (String)paramSparseArray1.next());
        if ((!paramSparseArray2.exists()) || (paramSparseArray2.delete()) || (paramSparseArray2.delete()) || (!paramSparseArray2.delete())) {}
      }
      bool2 = localFile.canWrite();
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("Q.richstatus.xml", 2, "removeOldIcons return with " + bool2);
    return bool2;
  }
  
  private Object[] a(InputStream paramInputStream)
  {
    int j = -1;
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.xml", 2, "parseXmlFile(" + paramInputStream + ")");
    }
    Object[] arrayOfObject = new Object[2];
    if (paramInputStream == null) {
      return arrayOfObject;
    }
    Object localObject2 = new bbcq();
    for (;;)
    {
      try
      {
        SAXParserFactory.newInstance().newSAXParser().parse(paramInputStream, (DefaultHandler)localObject2);
        SparseArray localSparseArray = ((bbcq)localObject2).a();
        localObject2 = ((bbcq)localObject2).a();
        if (localSparseArray.size() > 1) {
          arrayOfObject[0] = localSparseArray;
        }
        if (((ArrayList)localObject2).size() > 0) {
          arrayOfObject[1] = localObject2;
        }
      }
      catch (ParserConfigurationException localParserConfigurationException)
      {
        localParserConfigurationException.printStackTrace();
        try
        {
          paramInputStream.close();
        }
        catch (IOException paramInputStream)
        {
          paramInputStream.printStackTrace();
        }
        continue;
      }
      catch (SAXException localSAXException)
      {
        localSAXException.printStackTrace();
        try
        {
          paramInputStream.close();
        }
        catch (IOException paramInputStream)
        {
          paramInputStream.printStackTrace();
        }
        continue;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        try
        {
          paramInputStream.close();
        }
        catch (IOException paramInputStream)
        {
          paramInputStream.printStackTrace();
        }
        continue;
      }
      finally
      {
        try
        {
          paramInputStream.close();
          throw localObject1;
        }
        catch (IOException paramInputStream)
        {
          paramInputStream.printStackTrace();
          continue;
        }
        int i = -1;
        continue;
      }
      try
      {
        paramInputStream.close();
        if (QLog.isColorLevel())
        {
          paramInputStream = new StringBuilder().append("parseXmlFile return, action num: ");
          if (arrayOfObject[0] != null)
          {
            i = ((SparseArray)arrayOfObject[0]).size();
            paramInputStream = paramInputStream.append(i).append(" tag num: ");
            i = j;
            if (arrayOfObject[1] != null) {
              i = ((ArrayList)arrayOfObject[1]).size();
            }
            QLog.d("Q.richstatus.xml", 2, i);
          }
        }
        else
        {
          return arrayOfObject;
        }
      }
      catch (IOException paramInputStream)
      {
        paramInputStream.printStackTrace();
      }
    }
  }
  
  private int b()
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.xml", 2, "updateActions_Remote:" + l + ", " + this.jdField_b_of_type_Long + ", " + "rich_status_android");
    }
    if (Math.abs(l - this.jdField_b_of_type_Long) > 240000L)
    {
      anjo localanjo = (anjo)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(4);
      if (this.jdField_a_of_type_Anjq == null) {
        a();
      }
      localanjo.a(null, new GetResourceReqInfo[] { localanjo.d() });
      this.jdField_b_of_type_Long = l;
    }
    return 100;
  }
  
  private int b(boolean paramBoolean)
  {
    int i = 101;
    if (this.jdField_a_of_type_AndroidUtilSparseArray.size() == 0) {
      i = 102;
    }
    long l;
    do
    {
      return i;
      l = System.currentTimeMillis();
      if (Math.abs(this.jdField_c_of_type_Long - l) <= 43200000L) {
        break;
      }
    } while (!paramBoolean);
    if (Math.abs(this.jdField_d_of_type_Long - l) > 300000L)
    {
      this.jdField_d_of_type_Long = l;
      return 101;
    }
    return 100;
  }
  
  private SharedPreferences b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("rich_status" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
  }
  
  private void b()
  {
    this.jdField_a_of_type_Bbcp = new bbcn(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Bbcp);
  }
  
  private void b(boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    b().edit().putBoolean("k_sync_ss", paramBoolean).putLong("k_ss_time", l).commit();
  }
  
  private void c()
  {
    this.jdField_a_of_type_Anvc = new bbco(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anvc);
  }
  
  private boolean c()
  {
    int i = b(true);
    if (i != 100)
    {
      a(i);
      return true;
    }
    return false;
  }
  
  public int a(int paramInt)
  {
    if (paramInt == 102) {
      return a();
    }
    if (paramInt == 101) {
      return b();
    }
    return -1;
  }
  
  public int a(RichStatus paramRichStatus, int paramInt)
  {
    if (paramRichStatus == null) {}
    for (;;)
    {
      return 100;
      if (QLog.isColorLevel()) {
        QLog.i("Q.richstatus.set", 2, String.format("changeStatus %d,%d [%s]", new Object[] { Integer.valueOf(paramRichStatus.actionId), Integer.valueOf(paramInt), paramRichStatus.toSpannableString(null) }));
      }
      this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = paramRichStatus;
      if (paramRichStatus.isEmpty()) {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
        {
          paramRichStatus = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), StatusServlet.class);
          paramRichStatus.putExtra("k_cmd", 8);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(paramRichStatus);
        }
      }
      while (this.jdField_a_of_type_Bbcp == null)
      {
        b();
        return 100;
        byte[] arrayOfByte = paramRichStatus.encode();
        NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), StatusServlet.class);
        localNewIntent.putExtra("k_cmd", 9);
        localNewIntent.putExtra("k_tpl_id", paramRichStatus.tplId);
        localNewIntent.putExtra("k_font_id", paramRichStatus.fontId);
        localNewIntent.putExtra("k_sign_len", arrayOfByte.length);
        localNewIntent.putExtra("k_sign_data", arrayOfByte);
        localNewIntent.putExtra("k_source", paramInt);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
      }
    }
  }
  
  public int a(ArrayList<bbch> paramArrayList)
  {
    if (paramArrayList == null) {
      throw new InvalidParameterException("array list is null");
    }
    paramArrayList.clear();
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
      paramArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
    }
    return b(false);
  }
  
  public int a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.shuo", 2, "setSyncShuoShuo " + paramBoolean);
    }
    if (this.jdField_a_of_type_Bbcp == null) {
      b();
    }
    StatusServlet.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBoolean);
    return 100;
  }
  
  public long a()
  {
    return a().getLong("k_version", 0L);
  }
  
  public Bitmap a(int paramInt1, int paramInt2)
  {
    localObject7 = null;
    if (this.jdField_a_of_type_Bazr == null) {
      this.jdField_a_of_type_Bazr = new bazr("StatusIcon_", this);
    }
    localObject3 = (bazh)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1);
    Object localObject5 = paramInt1 + "_s_" + paramInt2;
    Object localObject6 = this.jdField_a_of_type_Bazr;
    Object localObject1;
    if (localObject3 != null) {
      if (paramInt2 == 201)
      {
        localObject1 = ((bazh)localObject3).jdField_a_of_type_JavaLangString;
        localObject6 = ((bazr)localObject6).a((String)localObject5, null, (String)localObject1);
        if ((localObject3 == null) && (c()) && (localObject6 == null)) {
          this.jdField_a_of_type_JavaUtilHashSet.add(localObject5);
        }
        if (paramInt2 != 201) {
          break label257;
        }
      }
    }
    try
    {
      if (BaseApplicationImpl.sImageCache != null)
      {
        localObject5 = (Bitmap)BaseApplicationImpl.sImageCache.get("StatusIcon_RichStatusDefaultBig");
        localObject1 = localObject5;
        localObject3 = localObject7;
        if (localObject5 == null) {
          localObject1 = localObject5;
        }
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      for (;;)
      {
        label209:
        localObject2 = null;
        label257:
        localObject3 = localObject7;
      }
    }
    try
    {
      localObject5 = bggl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources(), 2130849576);
      localObject1 = localObject5;
      BaseApplicationImpl.sImageCache.put("StatusIcon_RichStatusDefaultSmall", localObject5, (byte)0);
      localObject3 = localObject7;
      localObject1 = localObject5;
    }
    catch (OutOfMemoryError localOutOfMemoryError2)
    {
      Object localObject4 = localObject7;
      break label209;
      localObject2 = null;
      break label209;
      localObject2 = null;
      localObject4 = localObject7;
      break label209;
    }
    if (localObject6 != null) {
      localObject1 = localObject6;
    }
    while (paramInt2 == 201)
    {
      return localObject1;
      localObject1 = ((bazh)localObject3).b;
      break;
      localObject1 = null;
      break;
      localObject1 = bggl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources(), 2130849576);
      localObject3 = localObject7;
      break label209;
      if (paramInt2 != 200) {
        break label382;
      }
      if (BaseApplicationImpl.sImageCache != null)
      {
        localObject3 = (Bitmap)BaseApplicationImpl.sImageCache.get("StatusIcon_RichStatusDefaultSmall");
        if (localObject3 != null) {
          break label377;
        }
        localObject3 = bggl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources(), 2130849577);
        BaseApplicationImpl.sImageCache.put("StatusIcon_RichStatusDefaultSmall", localObject3, (byte)0);
        localObject1 = null;
        break label209;
      }
      localObject3 = bggl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources(), 2130849577);
      localObject1 = null;
      break label209;
    }
    return localObject3;
  }
  
  public bazh a(int paramInt)
  {
    bazh localbazh = (bazh)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localbazh == null) {
      c();
    }
    return localbazh;
  }
  
  public RichStatus a()
  {
    return a(true);
  }
  
  public RichStatus a(String paramString, boolean paramBoolean)
  {
    Object localObject = (anmw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    if (localObject != null)
    {
      paramString = ((anmw)localObject).a(paramString, paramBoolean);
      if (paramString == null) {}
    }
    for (paramString = paramString.getRichStatus();; paramString = null)
    {
      localObject = paramString;
      if (paramString == null) {
        localObject = new RichStatus(null);
      }
      return localObject;
    }
  }
  
  public RichStatus a(boolean paramBoolean)
  {
    Object localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus != null)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
      return localObject2;
    }
    Object localObject1 = (anmw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    if (localObject1 != null)
    {
      localObject1 = ((anmw)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramBoolean);
      if (localObject1 == null) {}
    }
    for (localObject1 = ((ExtensionInfo)localObject1).getRichStatus();; localObject1 = null)
    {
      localObject2 = localObject1;
      if (localObject1 != null) {
        break;
      }
      return new RichStatus(null);
    }
  }
  
  public String a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    return paramString1.replace("$I", Integer.toString(paramInt1)).replace("$U", Integer.toString(paramInt2)).replace("$A", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).replace("$N", paramString2);
  }
  
  protected ArrayList<UserProfile> a(ArrayList<UserProfile> paramArrayList)
  {
    HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
    int j = paramArrayList.size();
    Object localObject;
    if ((localHashMap != null) && (localHashMap.size() > 0) && (j > 0))
    {
      i = j - 1;
      while (i > -1)
      {
        localObject = (UserProfile)paramArrayList.get(i);
        UserProfile localUserProfile = (UserProfile)localHashMap.get(Long.valueOf(((UserProfile)localObject).lEctID));
        if (localUserProfile != null)
        {
          localUserProfile.bAge = ((UserProfile)localObject).bAge;
          localUserProfile.bSex = ((UserProfile)localObject).bSex;
          localUserProfile.strDesc = ((UserProfile)localObject).strDesc;
          paramArrayList.remove(i);
        }
        i -= 1;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("filterFriends ").append(j).append(" - ");
      if (localHashMap == null) {
        break label186;
      }
    }
    label186:
    for (int i = localHashMap.size();; i = -1)
    {
      QLog.d("Q.richstatus.mate", 2, i + "=" + paramArrayList.size());
      return paramArrayList;
    }
  }
  
  protected ArrayList<UserProfile> a(ArrayList<UserProfile> paramArrayList1, ArrayList<UserProfile> paramArrayList2, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    if (paramInt == -1)
    {
      localArrayList.addAll(paramArrayList1);
      localObject1 = paramArrayList1.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (UserProfile)((Iterator)localObject1).next();
        localHashMap.put(Long.valueOf(((UserProfile)localObject2).lEctID), localObject2);
      }
    }
    Object localObject1 = paramArrayList1.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (UserProfile)((Iterator)localObject1).next();
      if (((UserProfile)localObject2).bSex == paramInt)
      {
        localArrayList.add(localObject2);
        localHashMap.put(Long.valueOf(((UserProfile)localObject2).lEctID), localObject2);
      }
    }
    Object localObject2 = Long.valueOf(0L);
    try
    {
      long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      localObject1 = Long.valueOf(l);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.w("Q.richstatus.xml", 2, localException.toString());
          localObject1 = localObject2;
          continue;
          localException.bAge = ((UserProfile)localObject2).bAge;
          localException.bSex = ((UserProfile)localObject2).bSex;
          localException.strDesc = ((UserProfile)localObject2).strDesc;
        }
      }
      this.jdField_a_of_type_JavaUtilHashMap = localHashMap;
      if (!QLog.isColorLevel()) {
        break label385;
      }
      QLog.d("Q.richstatus.mate", 2, "mergeFriendsStrangers " + paramArrayList1.size() + " " + paramArrayList2.size() + " " + paramInt + "=" + localArrayList.size());
    }
    localHashMap.put(localObject1, new UserProfile());
    localObject1 = paramArrayList2.iterator();
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext()) {
        break label306;
      }
      localObject2 = (UserProfile)((Iterator)localObject1).next();
      UserProfile localUserProfile = (UserProfile)localHashMap.get(Long.valueOf(((UserProfile)localObject2).lEctID));
      if (localUserProfile != null) {
        break;
      }
      localArrayList.add(localObject2);
    }
    label306:
    return localArrayList;
  }
  
  public void a(long paramLong)
  {
    ((SignatureHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(41)).a(paramLong);
    if (this.jdField_a_of_type_Anvc == null) {
      c();
    }
  }
  
  public void a(Object paramObject)
  {
    if (paramObject == null) {}
    for (;;)
    {
      return;
      for (;;)
      {
        try
        {
          if ((paramObject instanceof bbaa))
          {
            if (this.jdField_a_of_type_JavaUtilLinkedList == null)
            {
              this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
              this.jdField_a_of_type_JavaUtilLinkedList.add((bbaa)paramObject);
            }
          }
          else
          {
            if ((paramObject instanceof bazy))
            {
              if (this.jdField_b_of_type_JavaUtilLinkedList != null) {
                break label228;
              }
              this.jdField_b_of_type_JavaUtilLinkedList = new LinkedList();
              this.jdField_b_of_type_JavaUtilLinkedList.add((bazy)paramObject);
            }
            if ((paramObject instanceof bbab))
            {
              if (this.jdField_c_of_type_JavaUtilLinkedList != null) {
                break label254;
              }
              this.jdField_c_of_type_JavaUtilLinkedList = new LinkedList();
              this.jdField_c_of_type_JavaUtilLinkedList.add((bbab)paramObject);
            }
            if ((paramObject instanceof bbad))
            {
              if (this.jdField_d_of_type_JavaUtilLinkedList != null) {
                break label280;
              }
              this.jdField_d_of_type_JavaUtilLinkedList = new LinkedList();
              this.jdField_d_of_type_JavaUtilLinkedList.add((bbad)paramObject);
            }
            if (!(paramObject instanceof bbac)) {
              break;
            }
            if (this.e != null) {
              break label306;
            }
            this.e = new LinkedList();
            this.e.add((bbac)paramObject);
            break;
          }
        }
        finally {}
        label280:
        if (!this.jdField_a_of_type_JavaUtilLinkedList.contains(paramObject))
        {
          this.jdField_a_of_type_JavaUtilLinkedList.add((bbaa)paramObject);
          continue;
          label228:
          if (!this.jdField_b_of_type_JavaUtilLinkedList.contains(paramObject))
          {
            this.jdField_b_of_type_JavaUtilLinkedList.add((bazy)paramObject);
            continue;
            label254:
            if (!this.jdField_c_of_type_JavaUtilLinkedList.contains(paramObject))
            {
              this.jdField_c_of_type_JavaUtilLinkedList.add((bbab)paramObject);
              continue;
              if (!this.jdField_d_of_type_JavaUtilLinkedList.contains(paramObject)) {
                this.jdField_d_of_type_JavaUtilLinkedList.add((bbad)paramObject);
              }
            }
          }
        }
      }
      label306:
      if (!this.e.contains(paramObject)) {
        this.e.add((bbac)paramObject);
      }
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "sp_hot_status", paramString).commit();
  }
  
  public void a(String paramString1, String paramString2, Bitmap paramBitmap, int paramInt)
  {
    if ((paramString2 == null) && (paramBitmap != null)) {
      this.jdField_a_of_type_JavaUtilHashSet.remove(paramString1);
    }
    paramString1 = paramString1.split("_");
    int i;
    if (paramString1.length == 3)
    {
      if (this.jdField_a_of_type_JavaUtilLinkedList != null)
      {
        paramInt = Integer.parseInt(paramString1[0]);
        i = Integer.parseInt(paramString1[2]);
        paramString1 = this.jdField_a_of_type_JavaUtilLinkedList.iterator();
        while (paramString1.hasNext()) {
          ((bbaa)paramString1.next()).a(paramInt, i, paramBitmap);
        }
      }
    }
    else if ((paramString1.length == 2) && (this.jdField_c_of_type_JavaUtilLinkedList != null))
    {
      i = Integer.parseInt(paramString1[0]);
      int j = Integer.parseInt(paramString1[1]);
      paramString1 = this.jdField_c_of_type_JavaUtilLinkedList.iterator();
      while (paramString1.hasNext()) {
        ((bbab)paramString1.next()).a(i, j, paramBitmap, paramInt);
      }
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if (((this.jdField_a_of_type_JavaUtilLinkedList == null) || (this.jdField_a_of_type_JavaUtilLinkedList.size() == 0)) && ((this.jdField_c_of_type_JavaUtilLinkedList == null) || (this.jdField_c_of_type_JavaUtilLinkedList.size() == 0)))
    {
      this.jdField_a_of_type_JavaUtilHashSet.clear();
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashSet.iterator();
    label50:
    String str;
    Object localObject1;
    Object localObject2;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        str = (String)localIterator.next();
        localObject1 = str.split("_");
        localObject2 = (bazh)this.jdField_a_of_type_AndroidUtilSparseArray.get(Integer.parseInt(localObject1[0]));
        if (localObject2 != null) {
          if (localObject1.length == 3) {
            if (Integer.parseInt(localObject1[2]) == 201) {
              localObject1 = ((bazh)localObject2).jdField_a_of_type_JavaLangString;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        localObject2 = this.jdField_a_of_type_Bazr.a(str, null, (String)localObject1);
        if (localObject2 == null) {
          break label50;
        }
        a(str, (String)localObject1, (Bitmap)localObject2, 1);
        break label50;
        localObject1 = ((bazh)localObject2).b;
        continue;
        if ((localObject1.length != 2) || (TextUtils.isEmpty(((bazh)localObject2).g))) {
          break label226;
        }
        localObject1 = ((bazh)localObject2).g.replace("$U", localObject1[1]);
        continue;
      }
      localIterator.remove();
      break label50;
      if (!paramBoolean) {
        break;
      }
      this.jdField_a_of_type_JavaUtilHashSet.clear();
      return;
      label226:
      localObject1 = null;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus != null;
  }
  
  public boolean a(long paramLong)
  {
    long l2 = a().getLong("k_version", 104L);
    long l1 = l2;
    if (l2 < 104L) {
      l1 = 104L;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.xml", 2, "StatusManager.isNewVersion(): localVersion " + l1 + " serverVersion " + paramLong + ", builtInVersion " + 104L);
    }
    return paramLong > l1;
  }
  
  public boolean a(File paramFile, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.xml", 2, "saveActions(" + paramFile + ", " + paramLong + ")");
    }
    for (;;)
    {
      try
      {
        Object localObject1 = a(new FileInputStream(paramFile));
        ??? = (SparseArray)localObject1[0];
        ArrayList localArrayList = (ArrayList)localObject1[1];
        if ((??? != null) && (((SparseArray)???).size() > 0) && (localArrayList != null) && (localArrayList.size() > 0))
        {
          localObject1 = this.jdField_a_of_type_AndroidUtilSparseArray;
          synchronized (this.jdField_a_of_type_AndroidUtilSparseArray)
          {
            AsyncTask localAsyncTask = this.jdField_a_of_type_AndroidOsAsyncTask;
            if (localAsyncTask != null) {
              localAsyncTask.cancel(true);
            }
            this.jdField_a_of_type_AndroidUtilSparseArray = ((SparseArray)???);
            if ((localArrayList == null) || (localArrayList.size() <= 0)) {}
          }
        }
        boolean bool;
        if (!QLog.isColorLevel()) {
          continue;
        }
      }
      catch (FileNotFoundException paramFile)
      {
        synchronized (this.jdField_a_of_type_JavaUtilArrayList)
        {
          this.jdField_a_of_type_JavaUtilArrayList.clear();
          this.jdField_a_of_type_JavaUtilArrayList.addAll(localArrayList);
          this.jdField_c_of_type_Long = System.currentTimeMillis();
          ??? = new File(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getFilesDir(), "rich_status.xml");
          if ((paramFile.renameTo((File)???)) || (paramFile.renameTo((File)???)) || (paramFile.renameTo((File)???)))
          {
            paramFile = a().edit();
            paramFile.putLong("k_version", paramLong).putLong("k_update_time", this.jdField_c_of_type_Long).commit();
            if (a((SparseArray)localObject1, this.jdField_a_of_type_AndroidUtilSparseArray)) {
              paramFile.putLong("k_icon", paramLong).commit();
            }
            bool = true;
            if (QLog.isColorLevel()) {
              QLog.d("Q.richstatus.xml", 2, "saveActions return with " + bool);
            }
            return bool;
            paramFile = finally;
            throw paramFile;
            paramFile = paramFile;
            paramFile.printStackTrace();
            bool = false;
          }
        }
      }
      QLog.d("Q.richstatus.xml", 2, "saveActions rename failed!");
    }
  }
  
  public void b(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return;
      if (((paramObject instanceof bbaa)) && (this.jdField_a_of_type_JavaUtilLinkedList != null)) {
        this.jdField_a_of_type_JavaUtilLinkedList.remove(paramObject);
      }
      if (((paramObject instanceof bazy)) && (this.jdField_b_of_type_JavaUtilLinkedList != null)) {
        this.jdField_b_of_type_JavaUtilLinkedList.remove(paramObject);
      }
      if (((paramObject instanceof bbab)) && (this.jdField_c_of_type_JavaUtilLinkedList != null)) {
        this.jdField_c_of_type_JavaUtilLinkedList.remove(paramObject);
      }
      if (((paramObject instanceof bbad)) && (this.jdField_d_of_type_JavaUtilLinkedList != null)) {
        this.jdField_d_of_type_JavaUtilLinkedList.remove(paramObject);
      }
    } while ((!(paramObject instanceof bbac)) || (this.e == null));
    this.e.remove(paramObject);
  }
  
  public boolean b()
  {
    SharedPreferences localSharedPreferences = b();
    boolean bool = localSharedPreferences.getBoolean("k_sync_ss", false);
    long l = System.currentTimeMillis();
    if ((Math.abs(l - this.jdField_a_of_type_Long) > 180000L) && (Math.abs(l - localSharedPreferences.getLong("k_ss_time", 0L)) > 60000L))
    {
      if (this.jdField_a_of_type_Bbcp == null) {
        b();
      }
      this.jdField_a_of_type_Long = l;
      StatusServlet.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.shuo", 2, "getSyncShuoShuo " + bool);
    }
    return bool;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbck
 * JD-Core Version:    0.7.0.1
 */