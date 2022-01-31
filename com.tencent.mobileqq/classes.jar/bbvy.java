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

public class bbvy
  extends BaseAdapter
  implements Handler.Callback, bbtc, bbvt, bhtv
{
  public static String a;
  public int a;
  public long a;
  private Context jdField_a_of_type_AndroidContentContext;
  public Handler a;
  private bbvn jdField_a_of_type_Bbvn;
  private bcmu jdField_a_of_type_Bcmu;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopFileTransferManager jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager;
  private List<bbsa> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map<UUID, bbvo> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  public int b;
  private long jdField_b_of_type_Long;
  public String b;
  private List<bbsa> jdField_b_of_type_JavaUtilList = new ArrayList(20);
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  
  static
  {
    jdField_a_of_type_JavaLangString = "TroopFileExpandableListAdapter<QFile>";
  }
  
  public bbvy(QQAppInterface paramQQAppInterface, Context paramContext, long paramLong, String paramString, int paramInt)
  {
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_b_of_type_Long = paramLong;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
    this.jdField_a_of_type_Bcmu = bcmu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
    this.jdField_a_of_type_Bcmu.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    if (!this.jdField_a_of_type_Bcmu.a(this)) {
      this.jdField_a_of_type_Bcmu.registerObserver(this);
    }
  }
  
  private List<bbsa> a(List<bbsa> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return paramList;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bbsa localbbsa = (bbsa)paramList.next();
      if ((TextUtils.isEmpty(localbbsa.jdField_b_of_type_JavaLangString)) || (!localbbsa.jdField_b_of_type_JavaLangString.contains("online_doc_folder_"))) {
        localArrayList.add(localbbsa);
      }
    }
    return localArrayList;
  }
  
  public List<bbsa> a()
  {
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  public void a()
  {
    int i;
    int j;
    if (this.jdField_a_of_type_Bbvn != null)
    {
      i = this.jdField_a_of_type_Bbvn.d();
      j = this.jdField_a_of_type_Bbvn.e();
    }
    for (;;)
    {
      if ((i > j - 1) || (i >= this.jdField_a_of_type_JavaUtilList.size())) {
        return;
      }
      Object localObject = (bbsa)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localObject == null) {}
      for (;;)
      {
        i += 1;
        break;
        localObject = (bbvo)this.jdField_a_of_type_JavaUtilMap.get(((bbsa)localObject).a);
        if (localObject != null)
        {
          ((bbvo)localObject).b(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          ((bbvo)localObject).a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
    boolean bool = bdin.g(this.jdField_a_of_type_AndroidContentContext);
    if ((bool) && (this.jdField_a_of_type_Bcmu.a(paramInt1, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Long)))
    {
      paramInt1 = 1;
      localObject = (bcna)this.jdField_a_of_type_Bcmu.d.get(this.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_Long);
      if (localObject == null) {
        break label169;
      }
    }
    label169:
    for (Object localObject = ((bcna)localObject).jdField_a_of_type_JavaUtilList;; localObject = null)
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
      bcnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
      return;
    }
  }
  
  public void a(bbsa parambbsa)
  {
    if ((parambbsa.jdField_e_of_type_Int == 2) || (parambbsa.jdField_e_of_type_Int == 3)) {
      return;
    }
    int j = this.jdField_a_of_type_JavaUtilList.size();
    bbsa localbbsa = (bbsa)this.jdField_a_of_type_Bcmu.c.get(parambbsa.f);
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        if ((this.jdField_a_of_type_JavaUtilList.get(i) == null) || (!((bbsa)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_b_of_type_JavaLangString.equals(parambbsa.jdField_b_of_type_JavaLangString))) {
          break label451;
        }
        bcna localbcna = (bcna)this.jdField_a_of_type_Bcmu.d.get(this.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_Long);
        if (localbcna == null) {
          break label451;
        }
        if ((localbcna.jdField_a_of_type_JavaUtilList != null) && (localbcna.jdField_a_of_type_JavaUtilMap != null))
        {
          localbcna.jdField_a_of_type_JavaUtilMap.remove(((bbsa)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_b_of_type_JavaLangString);
          if (i >= localbcna.jdField_a_of_type_JavaUtilList.size()) {
            break label421;
          }
          parambbsa = (bbsa)localbcna.jdField_a_of_type_JavaUtilList.remove(i);
          if ((parambbsa != null) && (parambbsa.jdField_e_of_type_Int != 12) && (localbbsa != null)) {
            localbbsa.h -= 1;
          }
          if ((parambbsa != null) && (parambbsa.jdField_e_of_type_Int != 12)) {
            localbcna.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
          }
          this.jdField_c_of_type_Boolean = false;
          a(localbcna.jdField_a_of_type_JavaUtilList, localbcna.jdField_a_of_type_Boolean, 0, false);
        }
      }
      for (;;)
      {
        if ((localbbsa == null) || (!"/".equals(this.jdField_b_of_type_JavaLangString)) || (this.jdField_a_of_type_Long != 0L) || (!localbbsa.d)) {
          break label449;
        }
        localbbsa.b((int)NetConnInfoCenter.getServerTime());
        parambbsa = (bcna)this.jdField_a_of_type_Bcmu.d.get(localbbsa.f + this.jdField_a_of_type_Long);
        if (parambbsa == null) {
          break;
        }
        if (parambbsa.jdField_a_of_type_JavaUtilList != null)
        {
          parambbsa.jdField_a_of_type_JavaUtilList.remove(localbbsa);
          parambbsa.jdField_a_of_type_JavaUtilList.add(0, localbbsa);
        }
        parambbsa.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
        a(parambbsa.jdField_a_of_type_JavaUtilList, parambbsa.jdField_a_of_type_Boolean, 0, false);
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
  
  public void a(bbsa parambbsa, String paramString)
  {
    if (parambbsa == null) {}
    do
    {
      do
      {
        bcna localbcna;
        do
        {
          return;
          if (!this.jdField_b_of_type_JavaLangString.equals("/")) {
            break;
          }
          localbcna = (bcna)this.jdField_a_of_type_Bcmu.d.get("/" + this.jdField_a_of_type_Long);
        } while ((localbcna == null) || (localbcna.jdField_a_of_type_JavaUtilList == null));
        bbsa localbbsa = (bbsa)this.jdField_a_of_type_Bcmu.c.get(paramString);
        if ((localbbsa != null) && (localbbsa.d))
        {
          localbbsa.h += 1;
          localbbsa.b((int)NetConnInfoCenter.getServerTime());
          j = this.jdField_a_of_type_JavaUtilList.size();
          i = 0;
          if (i < j)
          {
            if (localbbsa != this.jdField_a_of_type_JavaUtilList.get(i)) {
              break;
            }
            localbcna.jdField_a_of_type_JavaUtilList.remove(i);
          }
          localbcna.jdField_a_of_type_JavaUtilList.add(0, localbbsa);
          localbcna.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
          a(localbcna.jdField_a_of_type_JavaUtilList, localbcna.jdField_a_of_type_Boolean, 0, false);
        }
      } while (!this.jdField_b_of_type_JavaLangString.equals(paramString));
      paramString = (bcna)this.jdField_a_of_type_Bcmu.d.get(paramString + this.jdField_a_of_type_Long);
    } while ((paramString == null) || (paramString.jdField_a_of_type_JavaUtilList == null));
    boolean bool = paramString.jdField_a_of_type_Boolean;
    int j = this.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        if ((!((bbsa)this.jdField_a_of_type_JavaUtilList.get(i)).d) && (parambbsa.a() >= ((bbsa)this.jdField_a_of_type_JavaUtilList.get(i)).a()))
        {
          paramString.jdField_a_of_type_JavaUtilList.add(i, parambbsa);
          paramString.jdField_a_of_type_JavaUtilMap.put(parambbsa.jdField_b_of_type_JavaLangString, parambbsa);
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
        paramString.jdField_a_of_type_JavaUtilList.add(parambbsa);
        paramString.jdField_a_of_type_JavaUtilMap.put(parambbsa.jdField_b_of_type_JavaLangString, parambbsa);
        a(paramString.jdField_a_of_type_JavaUtilList, paramString.jdField_a_of_type_Boolean, 0, false);
      }
      i += 1;
    }
  }
  
  public void a(bbvn parambbvn)
  {
    this.jdField_a_of_type_Bbvn = parambbvn;
  }
  
  public void a(List<bbsa> paramList, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
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
    } while ((!paramBoolean1) || (!this.jdField_a_of_type_Bcmu.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Long)) || (this.jdField_a_of_type_Bbvn == null));
    this.jdField_a_of_type_Bbvn.d(7);
  }
  
  public void a(List<bbsa> paramList, boolean paramBoolean, String paramString, long paramLong)
  {
    if ((!this.jdField_b_of_type_JavaLangString.equals(paramString)) || (this.jdField_a_of_type_Long != paramLong)) {}
    do
    {
      return;
      if (paramList != null) {
        break;
      }
      if (this.jdField_a_of_type_Bbvn != null) {
        this.jdField_a_of_type_Bbvn.d(3);
      }
      arri.a(2131697984);
    } while (!this.jdField_a_of_type_JavaUtilList.isEmpty());
    b(1);
    return;
    if (this.jdField_a_of_type_Bbvn != null) {
      this.jdField_a_of_type_Bbvn.d(4);
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
  
  public void a(boolean paramBoolean, bbsa parambbsa)
  {
    if (this.jdField_b_of_type_JavaUtilList == null) {
      return;
    }
    if (parambbsa == null) {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "onSelected. fileInfo is null.");
    }
    if (paramBoolean) {
      if (!this.jdField_b_of_type_JavaUtilList.contains(parambbsa)) {
        this.jdField_b_of_type_JavaUtilList.add(parambbsa);
      }
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      this.jdField_b_of_type_JavaUtilList.remove(parambbsa);
    }
  }
  
  public boolean a(bbsa parambbsa)
  {
    if ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.isEmpty())) {
      return false;
    }
    return this.jdField_b_of_type_JavaUtilList.contains(parambbsa);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bcmu != null) {
      this.jdField_a_of_type_Bcmu.unregisterObserver(this);
    }
    if (this.jdField_b_of_type_JavaUtilList != null) {
      this.jdField_b_of_type_JavaUtilList.clear();
    }
  }
  
  protected void b(int paramInt)
  {
    if (this.jdField_a_of_type_Bbvn != null) {
      this.jdField_a_of_type_Bbvn.c(paramInt);
    }
  }
  
  public void b(bbsa parambbsa)
  {
    if (parambbsa == null) {}
    label146:
    do
    {
      do
      {
        do
        {
          bbvo localbbvo;
          do
          {
            return;
            switch (parambbsa.jdField_e_of_type_Int)
            {
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            default: 
              if ((!this.jdField_b_of_type_JavaLangString.equals(parambbsa.f)) && (this.jdField_a_of_type_Long == 0L)) {
                break label146;
              }
              localbbvo = (bbvo)this.jdField_a_of_type_JavaUtilMap.get(parambbsa.a);
            }
          } while ((localbbvo == null) || (!localbbvo.a.a.equals(parambbsa.a)));
          localbbvo.a = parambbsa;
          localbbvo.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Boolean);
          parambbsa = (bbsa)this.jdField_a_of_type_Bcmu.c.get(parambbsa.f);
        } while (parambbsa == null);
        parambbsa = (bbvo)this.jdField_a_of_type_JavaUtilMap.get(parambbsa.a);
      } while (parambbsa == null);
      parambbsa.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Boolean);
      return;
    } while (this.jdField_a_of_type_JavaUtilMap.remove(parambbsa.a) == null);
    this.jdField_c_of_type_Boolean = false;
    notifyDataSetChanged();
  }
  
  public void c(bbsa parambbsa) {}
  
  public void d(bbsa parambbsa)
  {
    Object localObject;
    bcna localbcna;
    if ((parambbsa.jdField_c_of_type_Boolean) && (parambbsa.jdField_e_of_type_Int == 6))
    {
      localObject = (bbsa)this.jdField_a_of_type_Bcmu.c.get(parambbsa.f);
      if ((localObject == null) || (!this.jdField_b_of_type_JavaLangString.equals(((bbsa)localObject).f)) || (!((bbsa)localObject).d)) {
        break label251;
      }
      localbcna = (bcna)this.jdField_a_of_type_Bcmu.d.get(((bbsa)localObject).f + this.jdField_a_of_type_Long);
      if ((localbcna != null) && (localbcna.jdField_a_of_type_JavaUtilList != null)) {
        break label121;
      }
    }
    label121:
    label251:
    do
    {
      return;
      if (TextUtils.isEmpty(parambbsa.c()))
      {
        if (parambbsa.jdField_b_of_type_Long != 0L) {
          break;
        }
        parambbsa.jdField_e_of_type_JavaLangString = bdgc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_b_of_type_Long + "", 1, 0);
      }
      localbcna.jdField_a_of_type_JavaUtilList.remove(localObject);
      ((bbsa)localObject).b(parambbsa.a());
      ((bbsa)localObject).h += 1;
      localbcna.jdField_a_of_type_JavaUtilList.add(0, localObject);
      a(localbcna.jdField_a_of_type_JavaUtilList, localbcna.jdField_a_of_type_Boolean, 0, false);
      localbcna.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
      if (!this.jdField_b_of_type_JavaLangString.equals(parambbsa.f)) {
        break label618;
      }
      localObject = (bcna)this.jdField_a_of_type_Bcmu.d.get(parambbsa.f + this.jdField_a_of_type_Long);
    } while ((localObject == null) || (((bcna)localObject).jdField_a_of_type_JavaUtilList == null));
    boolean bool = ((bcna)localObject).jdField_a_of_type_Boolean;
    int j = this.jdField_a_of_type_JavaUtilList.size();
    label397:
    int i;
    if (TextUtils.isEmpty(parambbsa.c()))
    {
      if (parambbsa.jdField_b_of_type_Long == 0L) {
        parambbsa.jdField_e_of_type_JavaLangString = bdgc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_b_of_type_Long + "", 1, 0);
      }
    }
    else
    {
      if (this.jdField_a_of_type_JavaUtilList.size() == 0)
      {
        ((bcna)localObject).jdField_a_of_type_JavaUtilList.add(parambbsa);
        ((bcna)localObject).jdField_a_of_type_JavaUtilMap.put(parambbsa.jdField_b_of_type_JavaLangString, parambbsa);
      }
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        if ((!((bbsa)this.jdField_a_of_type_JavaUtilList.get(i)).d) && (parambbsa.a() >= ((bbsa)this.jdField_a_of_type_JavaUtilList.get(i)).a()))
        {
          ((bcna)localObject).jdField_a_of_type_JavaUtilList.add(i, parambbsa);
          ((bcna)localObject).jdField_a_of_type_JavaUtilMap.put(parambbsa.jdField_b_of_type_JavaLangString, parambbsa);
          notifyDataSetChanged();
        }
      }
      else
      {
        ((bcna)localObject).jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
        a(((bcna)localObject).jdField_a_of_type_JavaUtilList, ((bcna)localObject).jdField_a_of_type_Boolean, 0, false);
        return;
        parambbsa.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
        break;
        parambbsa.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
        break label397;
      }
      if ((i == j - 1) && (bool))
      {
        ((bcna)localObject).jdField_a_of_type_JavaUtilList.add(parambbsa);
        ((bcna)localObject).jdField_a_of_type_JavaUtilMap.put(parambbsa.jdField_b_of_type_JavaLangString, parambbsa);
      }
      i += 1;
    }
    label618:
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void e(bbsa parambbsa)
  {
    if ((parambbsa.d) && ("/".equals(this.jdField_b_of_type_JavaLangString)) && (this.jdField_a_of_type_Long == 0L))
    {
      parambbsa.a = UUID.randomUUID();
      this.jdField_a_of_type_Bcmu.b.put(parambbsa.a, parambbsa);
      this.jdField_a_of_type_Bcmu.c.put(parambbsa.jdField_b_of_type_JavaLangString, parambbsa);
      bcna localbcna = (bcna)this.jdField_a_of_type_Bcmu.d.get(this.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_Long);
      if (localbcna != null)
      {
        if ((localbcna.jdField_a_of_type_JavaUtilList != null) && (localbcna.jdField_a_of_type_JavaUtilMap != null))
        {
          localbcna.jdField_a_of_type_JavaUtilList.add(0, parambbsa);
          localbcna.jdField_a_of_type_JavaUtilMap.put(parambbsa.jdField_b_of_type_JavaLangString, parambbsa);
        }
        this.jdField_a_of_type_Bcmu.c.put(parambbsa.jdField_b_of_type_JavaLangString, parambbsa);
        a(localbcna.jdField_a_of_type_JavaUtilList, localbcna.jdField_a_of_type_Boolean, 0, false);
        localbcna.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
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
    bbsa localbbsa = (bbsa)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (paramView == null)
    {
      paramViewGroup = new bbvo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_Long, 2131560688, this.jdField_c_of_type_Int);
      paramViewGroup.a(this);
      paramView = paramViewGroup.b;
      if (paramView == null) {
        return null;
      }
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilMap.put(localbbsa.a, paramViewGroup);
      if (paramViewGroup != null)
      {
        paramViewGroup.a = localbbsa;
        paramViewGroup.a(this.d);
        paramViewGroup.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if ((!this.d) || (!a(localbbsa))) {
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
        if (!(paramViewGroup instanceof bbvo)) {
          break label250;
        }
        paramViewGroup = (bbvo)paramViewGroup;
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
      if ((this.jdField_a_of_type_Int == this.jdField_b_of_type_Int - 2) && (this.jdField_a_of_type_Bcmu != null))
      {
        if (!this.jdField_a_of_type_Bcmu.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Long)) {
          break label88;
        }
        if (this.jdField_a_of_type_Bbvn != null) {
          this.jdField_a_of_type_Bbvn.d(8);
        }
      }
      label88:
      do
      {
        return;
        this.jdField_a_of_type_Bbvn.d(7);
      } while (bcnt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_Long) == 0);
      this.jdField_a_of_type_Bcmu.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Long);
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbvy
 * JD-Core Version:    0.7.0.1
 */