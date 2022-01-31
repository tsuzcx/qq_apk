import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class azte
  extends BaseAdapter
  implements Handler.Callback, azqi, azsz, bfob
{
  public static String a;
  public int a;
  public long a;
  private Context jdField_a_of_type_AndroidContentContext;
  public Handler a;
  private azst jdField_a_of_type_Azst;
  private bajk jdField_a_of_type_Bajk;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopFileTransferManager jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager;
  private List<azpg> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map<UUID, azsu> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  public int b;
  private long jdField_b_of_type_Long;
  public String b;
  private List<azpg> jdField_b_of_type_JavaUtilList = new ArrayList(20);
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  
  static
  {
    jdField_a_of_type_JavaLangString = "TroopFileExpandableListAdapter<QFile>";
  }
  
  public azte(QQAppInterface paramQQAppInterface, Context paramContext, long paramLong, String paramString, int paramInt)
  {
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_b_of_type_Long = paramLong;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
    this.jdField_a_of_type_Bajk = bajk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
    this.jdField_a_of_type_Bajk.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    if (!this.jdField_a_of_type_Bajk.a(this)) {
      this.jdField_a_of_type_Bajk.registerObserver(this);
    }
  }
  
  private List<azpg> a(List<azpg> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return paramList;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      azpg localazpg = (azpg)paramList.next();
      if ((TextUtils.isEmpty(localazpg.jdField_b_of_type_JavaLangString)) || (!localazpg.jdField_b_of_type_JavaLangString.contains("online_doc_folder_"))) {
        localArrayList.add(localazpg);
      }
    }
    return localArrayList;
  }
  
  public List<azpg> a()
  {
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  public void a()
  {
    int i;
    int j;
    if (this.jdField_a_of_type_Azst != null)
    {
      i = this.jdField_a_of_type_Azst.d();
      j = this.jdField_a_of_type_Azst.e();
    }
    for (;;)
    {
      if ((i > j - 1) || (i >= this.jdField_a_of_type_JavaUtilList.size())) {
        return;
      }
      Object localObject = (azpg)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localObject == null) {}
      for (;;)
      {
        i += 1;
        break;
        localObject = (azsu)this.jdField_a_of_type_JavaUtilMap.get(((azpg)localObject).a);
        if (localObject != null)
        {
          ((azsu)localObject).b(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          ((azsu)localObject).a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
      }
      j = 0;
      i = 0;
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    int i = 0;
    boolean bool = bbev.g(this.jdField_a_of_type_AndroidContentContext);
    if ((bool) && (this.jdField_a_of_type_Bajk.a(paramInt1, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Long)))
    {
      paramInt1 = 1;
      localObject = (bajq)this.jdField_a_of_type_Bajk.d.get(this.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_Long);
      if (localObject == null) {
        break label169;
      }
    }
    label169:
    for (Object localObject = ((bajq)localObject).jdField_a_of_type_JavaUtilList;; localObject = null)
    {
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        if (!bool)
        {
          b(0);
          a((List)localObject, true, paramInt2, true);
        }
        return;
        paramInt1 = 0;
        break;
      }
      if (bool)
      {
        if (paramInt1 != 0) {}
        for (paramInt1 = i;; paramInt1 = 2)
        {
          b(paramInt1);
          return;
        }
      }
      b(1);
      bakj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
      return;
    }
  }
  
  public void a(azpg paramazpg)
  {
    if ((paramazpg.jdField_e_of_type_Int == 2) || (paramazpg.jdField_e_of_type_Int == 3)) {
      return;
    }
    int j = this.jdField_a_of_type_JavaUtilList.size();
    azpg localazpg = (azpg)this.jdField_a_of_type_Bajk.c.get(paramazpg.f);
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        if ((this.jdField_a_of_type_JavaUtilList.get(i) == null) || (!((azpg)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_b_of_type_JavaLangString.equals(paramazpg.jdField_b_of_type_JavaLangString))) {
          break label451;
        }
        bajq localbajq = (bajq)this.jdField_a_of_type_Bajk.d.get(this.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_Long);
        if (localbajq == null) {
          break label451;
        }
        if ((localbajq.jdField_a_of_type_JavaUtilList != null) && (localbajq.jdField_a_of_type_JavaUtilMap != null))
        {
          localbajq.jdField_a_of_type_JavaUtilMap.remove(((azpg)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_b_of_type_JavaLangString);
          if (i >= localbajq.jdField_a_of_type_JavaUtilList.size()) {
            break label421;
          }
          paramazpg = (azpg)localbajq.jdField_a_of_type_JavaUtilList.remove(i);
          if ((paramazpg != null) && (paramazpg.jdField_e_of_type_Int != 12) && (localazpg != null)) {
            localazpg.h -= 1;
          }
          if ((paramazpg != null) && (paramazpg.jdField_e_of_type_Int != 12)) {
            localbajq.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
          }
          this.jdField_c_of_type_Boolean = false;
          a(localbajq.jdField_a_of_type_JavaUtilList, localbajq.jdField_a_of_type_Boolean, 0, false);
        }
      }
      for (;;)
      {
        if ((localazpg == null) || (!"/".equals(this.jdField_b_of_type_JavaLangString)) || (this.jdField_a_of_type_Long != 0L) || (!localazpg.d)) {
          break label449;
        }
        localazpg.b((int)NetConnInfoCenter.getServerTime());
        paramazpg = (bajq)this.jdField_a_of_type_Bajk.d.get(localazpg.f + this.jdField_a_of_type_Long);
        if (paramazpg == null) {
          break;
        }
        if (paramazpg.jdField_a_of_type_JavaUtilList != null)
        {
          paramazpg.jdField_a_of_type_JavaUtilList.remove(localazpg);
          paramazpg.jdField_a_of_type_JavaUtilList.add(0, localazpg);
        }
        paramazpg.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
        a(paramazpg.jdField_a_of_type_JavaUtilList, paramazpg.jdField_a_of_type_Boolean, 0, false);
        return;
        label421:
        QLog.e(jdField_a_of_type_JavaLangString, 1, "<TroopFile> onDelete remove has err.index>size" + i);
      }
      label449:
      break;
      label451:
      i += 1;
    }
  }
  
  public void a(azpg paramazpg, String paramString)
  {
    if (paramazpg == null) {}
    do
    {
      do
      {
        bajq localbajq;
        do
        {
          return;
          if (!this.jdField_b_of_type_JavaLangString.equals("/")) {
            break;
          }
          localbajq = (bajq)this.jdField_a_of_type_Bajk.d.get("/" + this.jdField_a_of_type_Long);
        } while ((localbajq == null) || (localbajq.jdField_a_of_type_JavaUtilList == null));
        azpg localazpg = (azpg)this.jdField_a_of_type_Bajk.c.get(paramString);
        if ((localazpg != null) && (localazpg.d))
        {
          localazpg.h += 1;
          localazpg.b((int)NetConnInfoCenter.getServerTime());
          j = this.jdField_a_of_type_JavaUtilList.size();
          i = 0;
          if (i < j)
          {
            if (localazpg != this.jdField_a_of_type_JavaUtilList.get(i)) {
              break;
            }
            localbajq.jdField_a_of_type_JavaUtilList.remove(i);
          }
          localbajq.jdField_a_of_type_JavaUtilList.add(0, localazpg);
          localbajq.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
          a(localbajq.jdField_a_of_type_JavaUtilList, localbajq.jdField_a_of_type_Boolean, 0, false);
        }
      } while (!this.jdField_b_of_type_JavaLangString.equals(paramString));
      paramString = (bajq)this.jdField_a_of_type_Bajk.d.get(paramString + this.jdField_a_of_type_Long);
    } while ((paramString == null) || (paramString.jdField_a_of_type_JavaUtilList == null));
    boolean bool = paramString.jdField_a_of_type_Boolean;
    int j = this.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        if ((!((azpg)this.jdField_a_of_type_JavaUtilList.get(i)).d) && (paramazpg.a() >= ((azpg)this.jdField_a_of_type_JavaUtilList.get(i)).a()))
        {
          paramString.jdField_a_of_type_JavaUtilList.add(i, paramazpg);
          paramString.jdField_a_of_type_JavaUtilMap.put(paramazpg.jdField_b_of_type_JavaLangString, paramazpg);
          a(paramString.jdField_a_of_type_JavaUtilList, paramString.jdField_a_of_type_Boolean, 0, false);
        }
      }
      else
      {
        paramString.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
        return;
        i += 1;
        break;
      }
      if ((i == j - 1) && (bool))
      {
        paramString.jdField_a_of_type_JavaUtilList.add(paramazpg);
        paramString.jdField_a_of_type_JavaUtilMap.put(paramazpg.jdField_b_of_type_JavaLangString, paramazpg);
        a(paramString.jdField_a_of_type_JavaUtilList, paramString.jdField_a_of_type_Boolean, 0, false);
      }
      i += 1;
    }
  }
  
  public void a(azst paramazst)
  {
    this.jdField_a_of_type_Azst = paramazst;
  }
  
  public void a(List<azpg> paramList, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    if (paramList == null) {}
    do
    {
      return;
      this.jdField_a_of_type_JavaUtilMap.clear();
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(a(paramList));
      if (paramList.size() == 0)
      {
        if ("/".equals(this.jdField_b_of_type_JavaLangString))
        {
          b(3);
          return;
        }
        b(6);
        return;
      }
      this.jdField_c_of_type_Boolean = false;
      notifyDataSetChanged();
      b(4);
    } while ((!paramBoolean1) || (!this.jdField_a_of_type_Bajk.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Long)) || (this.jdField_a_of_type_Azst == null));
    this.jdField_a_of_type_Azst.d(7);
  }
  
  public void a(List<azpg> paramList, boolean paramBoolean, String paramString, long paramLong)
  {
    if ((!this.jdField_b_of_type_JavaLangString.equals(paramString)) || (this.jdField_a_of_type_Long != paramLong)) {}
    do
    {
      return;
      if (paramList != null) {
        break;
      }
      if (this.jdField_a_of_type_Azst != null) {
        this.jdField_a_of_type_Azst.d(3);
      }
      aptv.a(2131697795);
    } while (!this.jdField_a_of_type_JavaUtilList.isEmpty());
    b(1);
    return;
    if (this.jdField_a_of_type_Azst != null) {
      this.jdField_a_of_type_Azst.d(4);
    }
    a(paramList, paramBoolean, 0, false);
  }
  
  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
    if ((!paramBoolean) && (this.jdField_b_of_type_JavaUtilList != null)) {
      this.jdField_b_of_type_JavaUtilList.clear();
    }
    notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean, azpg paramazpg)
  {
    if (this.jdField_b_of_type_JavaUtilList == null) {
      return;
    }
    if (paramazpg == null) {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "onSelected. fileInfo is null.");
    }
    if (paramBoolean) {
      if (!this.jdField_b_of_type_JavaUtilList.contains(paramazpg)) {
        this.jdField_b_of_type_JavaUtilList.add(paramazpg);
      }
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      this.jdField_b_of_type_JavaUtilList.remove(paramazpg);
    }
  }
  
  public boolean a(azpg paramazpg)
  {
    if ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.isEmpty())) {
      return false;
    }
    return this.jdField_b_of_type_JavaUtilList.contains(paramazpg);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bajk != null) {
      this.jdField_a_of_type_Bajk.unregisterObserver(this);
    }
    if (this.jdField_b_of_type_JavaUtilList != null) {
      this.jdField_b_of_type_JavaUtilList.clear();
    }
  }
  
  protected void b(int paramInt)
  {
    if (this.jdField_a_of_type_Azst != null) {
      this.jdField_a_of_type_Azst.c(paramInt);
    }
  }
  
  public void b(azpg paramazpg)
  {
    if (paramazpg == null) {}
    label146:
    do
    {
      do
      {
        do
        {
          azsu localazsu;
          do
          {
            return;
            switch (paramazpg.jdField_e_of_type_Int)
            {
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            default: 
              if ((!this.jdField_b_of_type_JavaLangString.equals(paramazpg.f)) && (this.jdField_a_of_type_Long == 0L)) {
                break label146;
              }
              localazsu = (azsu)this.jdField_a_of_type_JavaUtilMap.get(paramazpg.a);
            }
          } while ((localazsu == null) || (!localazsu.a.a.equals(paramazpg.a)));
          localazsu.a = paramazpg;
          localazsu.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Boolean);
          paramazpg = (azpg)this.jdField_a_of_type_Bajk.c.get(paramazpg.f);
        } while (paramazpg == null);
        paramazpg = (azsu)this.jdField_a_of_type_JavaUtilMap.get(paramazpg.a);
      } while (paramazpg == null);
      paramazpg.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Boolean);
      return;
    } while (this.jdField_a_of_type_JavaUtilMap.remove(paramazpg.a) == null);
    this.jdField_c_of_type_Boolean = false;
    notifyDataSetChanged();
  }
  
  public void c(azpg paramazpg) {}
  
  public void d(azpg paramazpg)
  {
    Object localObject;
    bajq localbajq;
    if ((paramazpg.jdField_c_of_type_Boolean) && (paramazpg.jdField_e_of_type_Int == 6))
    {
      localObject = (azpg)this.jdField_a_of_type_Bajk.c.get(paramazpg.f);
      if ((localObject == null) || (!this.jdField_b_of_type_JavaLangString.equals(((azpg)localObject).f)) || (!((azpg)localObject).d)) {
        break label251;
      }
      localbajq = (bajq)this.jdField_a_of_type_Bajk.d.get(((azpg)localObject).f + this.jdField_a_of_type_Long);
      if ((localbajq != null) && (localbajq.jdField_a_of_type_JavaUtilList != null)) {
        break label121;
      }
    }
    label121:
    label251:
    do
    {
      return;
      if (TextUtils.isEmpty(paramazpg.c()))
      {
        if (paramazpg.jdField_b_of_type_Long != 0L) {
          break;
        }
        paramazpg.jdField_e_of_type_JavaLangString = bbcl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_b_of_type_Long + "", 1, 0);
      }
      localbajq.jdField_a_of_type_JavaUtilList.remove(localObject);
      ((azpg)localObject).b(paramazpg.a());
      ((azpg)localObject).h += 1;
      localbajq.jdField_a_of_type_JavaUtilList.add(0, localObject);
      a(localbajq.jdField_a_of_type_JavaUtilList, localbajq.jdField_a_of_type_Boolean, 0, false);
      localbajq.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
      if (!this.jdField_b_of_type_JavaLangString.equals(paramazpg.f)) {
        break label618;
      }
      localObject = (bajq)this.jdField_a_of_type_Bajk.d.get(paramazpg.f + this.jdField_a_of_type_Long);
    } while ((localObject == null) || (((bajq)localObject).jdField_a_of_type_JavaUtilList == null));
    boolean bool = ((bajq)localObject).jdField_a_of_type_Boolean;
    int j = this.jdField_a_of_type_JavaUtilList.size();
    label397:
    int i;
    if (TextUtils.isEmpty(paramazpg.c()))
    {
      if (paramazpg.jdField_b_of_type_Long == 0L) {
        paramazpg.jdField_e_of_type_JavaLangString = bbcl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_b_of_type_Long + "", 1, 0);
      }
    }
    else
    {
      if (this.jdField_a_of_type_JavaUtilList.size() == 0)
      {
        ((bajq)localObject).jdField_a_of_type_JavaUtilList.add(paramazpg);
        ((bajq)localObject).jdField_a_of_type_JavaUtilMap.put(paramazpg.jdField_b_of_type_JavaLangString, paramazpg);
      }
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        if ((!((azpg)this.jdField_a_of_type_JavaUtilList.get(i)).d) && (paramazpg.a() >= ((azpg)this.jdField_a_of_type_JavaUtilList.get(i)).a()))
        {
          ((bajq)localObject).jdField_a_of_type_JavaUtilList.add(i, paramazpg);
          ((bajq)localObject).jdField_a_of_type_JavaUtilMap.put(paramazpg.jdField_b_of_type_JavaLangString, paramazpg);
          notifyDataSetChanged();
        }
      }
      else
      {
        ((bajq)localObject).jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
        a(((bajq)localObject).jdField_a_of_type_JavaUtilList, ((bajq)localObject).jdField_a_of_type_Boolean, 0, false);
        return;
        paramazpg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
        break;
        paramazpg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
        break label397;
      }
      if ((i == j - 1) && (bool))
      {
        ((bajq)localObject).jdField_a_of_type_JavaUtilList.add(paramazpg);
        ((bajq)localObject).jdField_a_of_type_JavaUtilMap.put(paramazpg.jdField_b_of_type_JavaLangString, paramazpg);
      }
      i += 1;
    }
    label618:
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void e(azpg paramazpg)
  {
    if ((paramazpg.d) && ("/".equals(this.jdField_b_of_type_JavaLangString)) && (this.jdField_a_of_type_Long == 0L))
    {
      paramazpg.a = UUID.randomUUID();
      this.jdField_a_of_type_Bajk.b.put(paramazpg.a, paramazpg);
      this.jdField_a_of_type_Bajk.c.put(paramazpg.jdField_b_of_type_JavaLangString, paramazpg);
      bajq localbajq = (bajq)this.jdField_a_of_type_Bajk.d.get(this.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_Long);
      if (localbajq != null)
      {
        if ((localbajq.jdField_a_of_type_JavaUtilList != null) && (localbajq.jdField_a_of_type_JavaUtilMap != null))
        {
          localbajq.jdField_a_of_type_JavaUtilList.add(0, paramazpg);
          localbajq.jdField_a_of_type_JavaUtilMap.put(paramazpg.jdField_b_of_type_JavaLangString, paramazpg);
        }
        this.jdField_a_of_type_Bajk.c.put(paramazpg.jdField_b_of_type_JavaLangString, paramazpg);
        a(localbajq.jdField_a_of_type_JavaUtilList, localbajq.jdField_a_of_type_Boolean, 0, false);
        localbajq.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
      }
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramInt >= this.jdField_a_of_type_JavaUtilList.size()) {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "getView: error. position[" + paramInt + "] fileListSize[" + this.jdField_a_of_type_JavaUtilList.size() + "]");
    }
    azpg localazpg = (azpg)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (paramView == null)
    {
      paramViewGroup = new azsu(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_Long, 2131560495, this.jdField_c_of_type_Int);
      paramViewGroup.a(this);
      paramView = paramViewGroup.b;
      if (paramView == null) {
        return null;
      }
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilMap.put(localazpg.a, paramViewGroup);
      if (paramViewGroup != null)
      {
        paramViewGroup.a = localazpg;
        paramViewGroup.a(this.d);
        paramViewGroup.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if ((!this.d) || (!a(localazpg))) {
          break label244;
        }
      }
      label244:
      for (boolean bool = true;; bool = false)
      {
        paramViewGroup.b(bool);
        paramViewGroup.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Boolean);
        return paramView;
        paramViewGroup = paramView.getTag();
        if (!(paramViewGroup instanceof azsu)) {
          break label250;
        }
        paramViewGroup = (azsu)paramViewGroup;
        break;
      }
      label250:
      paramViewGroup = null;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = false;
        a();
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_b_of_type_Int = paramInt3;
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2 - 1 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0)
    {
      this.jdField_b_of_type_Boolean = true;
      QLog.e(jdField_a_of_type_JavaLangString, 4, "onScrollStateChanged=SCROLL_STATE_IDLE");
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, 1000L);
      if ((this.jdField_a_of_type_Int == this.jdField_b_of_type_Int - 2) && (this.jdField_a_of_type_Bajk != null))
      {
        if (!this.jdField_a_of_type_Bajk.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Long)) {
          break label88;
        }
        if (this.jdField_a_of_type_Azst != null) {
          this.jdField_a_of_type_Azst.d(8);
        }
      }
      label88:
      do
      {
        return;
        this.jdField_a_of_type_Azst.d(7);
      } while (bakj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_Long) == 0);
      this.jdField_a_of_type_Bajk.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Long);
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azte
 * JD-Core Version:    0.7.0.1
 */