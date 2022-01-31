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

public class avev
  implements avcd, Manager
{
  private static volatile WeakReference<avev> jdField_a_of_type_JavaLangRefWeakReference;
  private static Object[] jdField_a_of_type_ArrayOfJavaLangObject = new Object[2];
  private long jdField_a_of_type_Long;
  private ajgf jdField_a_of_type_Ajgf;
  private ajsf jdField_a_of_type_Ajsf;
  private volatile AsyncTask<Void, Integer, Integer> jdField_a_of_type_AndroidOsAsyncTask;
  private volatile SparseArray<avbr> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private avcb jdField_a_of_type_Avcb;
  private avfa jdField_a_of_type_Avfa;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private RichStatus jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
  private ArrayList<aves> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap<Long, UserProfile> jdField_a_of_type_JavaUtilHashMap;
  private HashSet<String> jdField_a_of_type_JavaUtilHashSet;
  private LinkedList<avck> jdField_a_of_type_JavaUtilLinkedList;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private long jdField_b_of_type_Long;
  private AsyncTask<Void, Void, ArrayList<UserProfile>> jdField_b_of_type_AndroidOsAsyncTask;
  private ArrayList<UserProfile> jdField_b_of_type_JavaUtilArrayList;
  private LinkedList<avci> jdField_b_of_type_JavaUtilLinkedList;
  private long jdField_c_of_type_Long;
  private ArrayList<UserProfile> jdField_c_of_type_JavaUtilArrayList;
  private LinkedList<avcl> jdField_c_of_type_JavaUtilLinkedList;
  private long jdField_d_of_type_Long;
  private LinkedList<avcn> jdField_d_of_type_JavaUtilLinkedList;
  private LinkedList<avcm> e;
  
  private avev(QQAppInterface paramQQAppInterface)
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
    this.jdField_a_of_type_AndroidOsAsyncTask = new avew(this).execute(new Void[0]);
    return 100;
  }
  
  private SharedPreferences a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("rich_status", 0);
  }
  
  public static avev a(QQAppInterface paramQQAppInterface)
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localObject != paramQQAppInterface) {
      return (avev)((QQAppInterface)localObject).getManager(15);
    }
    if (jdField_a_of_type_JavaLangRefWeakReference != null) {}
    for (localObject = (avev)jdField_a_of_type_JavaLangRefWeakReference.get();; localObject = null)
    {
      if (localObject == null)
      {
        paramQQAppInterface = new avev(paramQQAppInterface);
        jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
        return paramQQAppInterface;
      }
      ((avev)localObject).jdField_a_of_type_JavaUtilHashSet.clear();
      ((avev)localObject).jdField_b_of_type_Long = 0L;
      ((avev)localObject).jdField_a_of_type_Long = 0L;
      ((avev)localObject).jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus = null;
      if (((avev)localObject).jdField_a_of_type_Ajgf != null)
      {
        ((avev)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(((avev)localObject).jdField_a_of_type_Ajgf);
        ((avev)localObject).jdField_a_of_type_Ajgf = null;
      }
      if (((avev)localObject).jdField_a_of_type_Avfa != null)
      {
        ((avev)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.unRegistObserver(((avev)localObject).jdField_a_of_type_Avfa);
        ((avev)localObject).jdField_a_of_type_Avfa = null;
      }
      if (((avev)localObject).jdField_a_of_type_Avcb != null) {
        ((avev)localObject).jdField_a_of_type_Avcb.a();
      }
      if (((avev)localObject).jdField_a_of_type_Ajsf != null)
      {
        ((avev)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(((avev)localObject).jdField_a_of_type_Ajsf);
        ((avev)localObject).jdField_a_of_type_Ajsf = null;
      }
      ((avev)localObject).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      return localObject;
    }
  }
  
  private void a()
  {
    this.jdField_a_of_type_Ajgf = new avex(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajgf);
  }
  
  private boolean a(SparseArray<avbr> paramSparseArray1, SparseArray<avbr> paramSparseArray2)
  {
    int i = 0;
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.xml", 2, "removeOldIcons(" + paramSparseArray1 + ", " + paramSparseArray2 + ")");
    }
    File localFile = avcb.a();
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
        avbr localavbr1 = (avbr)paramSparseArray2.valueAt(i);
        avbr localavbr2 = (avbr)paramSparseArray1.get(localavbr1.jdField_a_of_type_Int);
        if ((localavbr2 != null) && (localavbr2.jdField_a_of_type_JavaLangString != null) && (!localavbr2.jdField_a_of_type_JavaLangString.equalsIgnoreCase(localavbr1.jdField_a_of_type_JavaLangString))) {
          localArrayList.add(localavbr2.jdField_a_of_type_Int + "_s_" + 201);
        }
        if ((localavbr2 != null) && (localavbr2.b != null) && (!localavbr2.b.equalsIgnoreCase(localavbr1.b))) {
          localArrayList.add(localavbr2.jdField_a_of_type_Int + "_s_" + 200);
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
    Object localObject2 = new avfb();
    for (;;)
    {
      try
      {
        SAXParserFactory.newInstance().newSAXParser().parse(paramInputStream, (DefaultHandler)localObject2);
        SparseArray localSparseArray = ((avfb)localObject2).a();
        localObject2 = ((avfb)localObject2).a();
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
      ajgd localajgd = (ajgd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(4);
      if (this.jdField_a_of_type_Ajgf == null) {
        a();
      }
      localajgd.a(null, new GetResourceReqInfo[] { localajgd.d() });
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
    this.jdField_a_of_type_Avfa = new avey(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registObserver(this.jdField_a_of_type_Avfa);
  }
  
  private void b(boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    b().edit().putBoolean("k_sync_ss", paramBoolean).putLong("k_ss_time", l).commit();
  }
  
  private void c()
  {
    this.jdField_a_of_type_Ajsf = new avez(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajsf);
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
      while (this.jdField_a_of_type_Avfa == null)
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
  
  public int a(ArrayList<aves> paramArrayList)
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
    if (this.jdField_a_of_type_Avfa == null) {
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
    if (this.jdField_a_of_type_Avcb == null) {
      this.jdField_a_of_type_Avcb = new avcb("StatusIcon_", this);
    }
    localObject3 = (avbr)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1);
    Object localObject5 = paramInt1 + "_s_" + paramInt2;
    Object localObject6 = this.jdField_a_of_type_Avcb;
    Object localObject1;
    if (localObject3 != null) {
      if (paramInt2 == 201)
      {
        localObject1 = ((avbr)localObject3).jdField_a_of_type_JavaLangString;
        localObject6 = ((avcb)localObject6).a((String)localObject5, null, (String)localObject1);
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
      localObject5 = azvq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources(), 2130848300);
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
      localObject1 = ((avbr)localObject3).b;
      break;
      localObject1 = null;
      break;
      localObject1 = azvq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources(), 2130848300);
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
        localObject3 = azvq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources(), 2130848301);
        BaseApplicationImpl.sImageCache.put("StatusIcon_RichStatusDefaultSmall", localObject3, (byte)0);
        localObject1 = null;
        break label209;
      }
      localObject3 = azvq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources(), 2130848301);
      localObject1 = null;
      break label209;
    }
    return localObject3;
  }
  
  public avbr a(int paramInt)
  {
    avbr localavbr = (avbr)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localavbr == null) {
      c();
    }
    return localavbr;
  }
  
  public RichStatus a()
  {
    return a(true);
  }
  
  public RichStatus a(String paramString, boolean paramBoolean)
  {
    Object localObject = (ajjj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    if (localObject != null)
    {
      paramString = ((ajjj)localObject).a(paramString, paramBoolean);
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
    Object localObject1 = (ajjj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    if (localObject1 != null)
    {
      localObject1 = ((ajjj)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramBoolean);
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
    if (this.jdField_a_of_type_Ajsf == null) {
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
          if ((paramObject instanceof avck))
          {
            if (this.jdField_a_of_type_JavaUtilLinkedList == null)
            {
              this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
              this.jdField_a_of_type_JavaUtilLinkedList.add((avck)paramObject);
            }
          }
          else
          {
            if ((paramObject instanceof avci))
            {
              if (this.jdField_b_of_type_JavaUtilLinkedList != null) {
                break label228;
              }
              this.jdField_b_of_type_JavaUtilLinkedList = new LinkedList();
              this.jdField_b_of_type_JavaUtilLinkedList.add((avci)paramObject);
            }
            if ((paramObject instanceof avcl))
            {
              if (this.jdField_c_of_type_JavaUtilLinkedList != null) {
                break label254;
              }
              this.jdField_c_of_type_JavaUtilLinkedList = new LinkedList();
              this.jdField_c_of_type_JavaUtilLinkedList.add((avcl)paramObject);
            }
            if ((paramObject instanceof avcn))
            {
              if (this.jdField_d_of_type_JavaUtilLinkedList != null) {
                break label280;
              }
              this.jdField_d_of_type_JavaUtilLinkedList = new LinkedList();
              this.jdField_d_of_type_JavaUtilLinkedList.add((avcn)paramObject);
            }
            if (!(paramObject instanceof avcm)) {
              break;
            }
            if (this.e != null) {
              break label306;
            }
            this.e = new LinkedList();
            this.e.add((avcm)paramObject);
            break;
          }
        }
        finally {}
        label280:
        if (!this.jdField_a_of_type_JavaUtilLinkedList.contains(paramObject))
        {
          this.jdField_a_of_type_JavaUtilLinkedList.add((avck)paramObject);
          continue;
          label228:
          if (!this.jdField_b_of_type_JavaUtilLinkedList.contains(paramObject))
          {
            this.jdField_b_of_type_JavaUtilLinkedList.add((avci)paramObject);
            continue;
            label254:
            if (!this.jdField_c_of_type_JavaUtilLinkedList.contains(paramObject))
            {
              this.jdField_c_of_type_JavaUtilLinkedList.add((avcl)paramObject);
              continue;
              if (!this.jdField_d_of_type_JavaUtilLinkedList.contains(paramObject)) {
                this.jdField_d_of_type_JavaUtilLinkedList.add((avcn)paramObject);
              }
            }
          }
        }
      }
      label306:
      if (!this.e.contains(paramObject)) {
        this.e.add((avcm)paramObject);
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
          ((avck)paramString1.next()).a(paramInt, i, paramBitmap);
        }
      }
    }
    else if ((paramString1.length == 2) && (this.jdField_c_of_type_JavaUtilLinkedList != null))
    {
      i = Integer.parseInt(paramString1[0]);
      int j = Integer.parseInt(paramString1[1]);
      paramString1 = this.jdField_c_of_type_JavaUtilLinkedList.iterator();
      while (paramString1.hasNext()) {
        ((avcl)paramString1.next()).a(i, j, paramBitmap, paramInt);
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
        localObject2 = (avbr)this.jdField_a_of_type_AndroidUtilSparseArray.get(Integer.parseInt(localObject1[0]));
        if (localObject2 != null) {
          if (localObject1.length == 3) {
            if (Integer.parseInt(localObject1[2]) == 201) {
              localObject1 = ((avbr)localObject2).jdField_a_of_type_JavaLangString;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        localObject2 = this.jdField_a_of_type_Avcb.a(str, null, (String)localObject1);
        if (localObject2 == null) {
          break label50;
        }
        a(str, (String)localObject1, (Bitmap)localObject2, 1);
        break label50;
        localObject1 = ((avbr)localObject2).b;
        continue;
        if ((localObject1.length != 2) || (TextUtils.isEmpty(((avbr)localObject2).g))) {
          break label226;
        }
        localObject1 = ((avbr)localObject2).g.replace("$U", localObject1[1]);
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
      if (((paramObject instanceof avck)) && (this.jdField_a_of_type_JavaUtilLinkedList != null)) {
        this.jdField_a_of_type_JavaUtilLinkedList.remove(paramObject);
      }
      if (((paramObject instanceof avci)) && (this.jdField_b_of_type_JavaUtilLinkedList != null)) {
        this.jdField_b_of_type_JavaUtilLinkedList.remove(paramObject);
      }
      if (((paramObject instanceof avcl)) && (this.jdField_c_of_type_JavaUtilLinkedList != null)) {
        this.jdField_c_of_type_JavaUtilLinkedList.remove(paramObject);
      }
      if (((paramObject instanceof avcn)) && (this.jdField_d_of_type_JavaUtilLinkedList != null)) {
        this.jdField_d_of_type_JavaUtilLinkedList.remove(paramObject);
      }
    } while ((!(paramObject instanceof avcm)) || (this.e == null));
    this.e.remove(paramObject);
  }
  
  public boolean b()
  {
    SharedPreferences localSharedPreferences = b();
    boolean bool = localSharedPreferences.getBoolean("k_sync_ss", false);
    long l = System.currentTimeMillis();
    if ((Math.abs(l - this.jdField_a_of_type_Long) > 180000L) && (Math.abs(l - localSharedPreferences.getLong("k_ss_time", 0L)) > 60000L))
    {
      if (this.jdField_a_of_type_Avfa == null) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avev
 * JD-Core Version:    0.7.0.1
 */