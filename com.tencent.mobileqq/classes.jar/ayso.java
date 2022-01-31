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

public class ayso
  extends BaseAdapter
  implements Handler.Callback, ayps, aysj, begh
{
  public static String a;
  public int a;
  public long a;
  private Context jdField_a_of_type_AndroidContentContext;
  public Handler a;
  private aysd jdField_a_of_type_Aysd;
  private azih jdField_a_of_type_Azih;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopFileTransferManager jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager;
  private List<ayoq> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map<UUID, ayse> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  public int b;
  private long jdField_b_of_type_Long;
  public String b;
  private List<ayoq> jdField_b_of_type_JavaUtilList = new ArrayList(20);
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  
  static
  {
    jdField_a_of_type_JavaLangString = "TroopFileExpandableListAdapter<QFile>";
  }
  
  public ayso(QQAppInterface paramQQAppInterface, Context paramContext, long paramLong, String paramString, int paramInt)
  {
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_b_of_type_Long = paramLong;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
    this.jdField_a_of_type_Azih = azih.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
    this.jdField_a_of_type_Azih.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    if (!this.jdField_a_of_type_Azih.a(this)) {
      this.jdField_a_of_type_Azih.registerObserver(this);
    }
  }
  
  private List<ayoq> a(List<ayoq> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return paramList;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ayoq localayoq = (ayoq)paramList.next();
      if ((TextUtils.isEmpty(localayoq.jdField_b_of_type_JavaLangString)) || (!localayoq.jdField_b_of_type_JavaLangString.contains("online_doc_folder_"))) {
        localArrayList.add(localayoq);
      }
    }
    return localArrayList;
  }
  
  public List<ayoq> a()
  {
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  public void a()
  {
    int i;
    int j;
    if (this.jdField_a_of_type_Aysd != null)
    {
      i = this.jdField_a_of_type_Aysd.d();
      j = this.jdField_a_of_type_Aysd.e();
    }
    for (;;)
    {
      if ((i > j - 1) || (i >= this.jdField_a_of_type_JavaUtilList.size())) {
        return;
      }
      Object localObject = (ayoq)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localObject == null) {}
      for (;;)
      {
        i += 1;
        break;
        localObject = (ayse)this.jdField_a_of_type_JavaUtilMap.get(((ayoq)localObject).a);
        if (localObject != null)
        {
          ((ayse)localObject).b(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          ((ayse)localObject).a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
    boolean bool = badq.g(this.jdField_a_of_type_AndroidContentContext);
    if ((bool) && (this.jdField_a_of_type_Azih.a(paramInt1, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Long)))
    {
      paramInt1 = 1;
      localObject = (azin)this.jdField_a_of_type_Azih.d.get(this.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_Long);
      if (localObject == null) {
        break label169;
      }
    }
    label169:
    for (Object localObject = ((azin)localObject).jdField_a_of_type_JavaUtilList;; localObject = null)
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
      azjg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
      return;
    }
  }
  
  public void a(ayoq paramayoq)
  {
    if ((paramayoq.jdField_e_of_type_Int == 2) || (paramayoq.jdField_e_of_type_Int == 3)) {
      return;
    }
    int j = this.jdField_a_of_type_JavaUtilList.size();
    ayoq localayoq = (ayoq)this.jdField_a_of_type_Azih.c.get(paramayoq.f);
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        if ((this.jdField_a_of_type_JavaUtilList.get(i) == null) || (!((ayoq)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_b_of_type_JavaLangString.equals(paramayoq.jdField_b_of_type_JavaLangString))) {
          break label451;
        }
        azin localazin = (azin)this.jdField_a_of_type_Azih.d.get(this.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_Long);
        if (localazin == null) {
          break label451;
        }
        if ((localazin.jdField_a_of_type_JavaUtilList != null) && (localazin.jdField_a_of_type_JavaUtilMap != null))
        {
          localazin.jdField_a_of_type_JavaUtilMap.remove(((ayoq)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_b_of_type_JavaLangString);
          if (i >= localazin.jdField_a_of_type_JavaUtilList.size()) {
            break label421;
          }
          paramayoq = (ayoq)localazin.jdField_a_of_type_JavaUtilList.remove(i);
          if ((paramayoq != null) && (paramayoq.jdField_e_of_type_Int != 12) && (localayoq != null)) {
            localayoq.h -= 1;
          }
          if ((paramayoq != null) && (paramayoq.jdField_e_of_type_Int != 12)) {
            localazin.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
          }
          this.jdField_c_of_type_Boolean = false;
          a(localazin.jdField_a_of_type_JavaUtilList, localazin.jdField_a_of_type_Boolean, 0, false);
        }
      }
      for (;;)
      {
        if ((localayoq == null) || (!"/".equals(this.jdField_b_of_type_JavaLangString)) || (this.jdField_a_of_type_Long != 0L) || (!localayoq.d)) {
          break label449;
        }
        localayoq.b((int)NetConnInfoCenter.getServerTime());
        paramayoq = (azin)this.jdField_a_of_type_Azih.d.get(localayoq.f + this.jdField_a_of_type_Long);
        if (paramayoq == null) {
          break;
        }
        if (paramayoq.jdField_a_of_type_JavaUtilList != null)
        {
          paramayoq.jdField_a_of_type_JavaUtilList.remove(localayoq);
          paramayoq.jdField_a_of_type_JavaUtilList.add(0, localayoq);
        }
        paramayoq.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
        a(paramayoq.jdField_a_of_type_JavaUtilList, paramayoq.jdField_a_of_type_Boolean, 0, false);
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
  
  public void a(ayoq paramayoq, String paramString)
  {
    if (paramayoq == null) {}
    do
    {
      do
      {
        azin localazin;
        do
        {
          return;
          if (!this.jdField_b_of_type_JavaLangString.equals("/")) {
            break;
          }
          localazin = (azin)this.jdField_a_of_type_Azih.d.get("/" + this.jdField_a_of_type_Long);
        } while ((localazin == null) || (localazin.jdField_a_of_type_JavaUtilList == null));
        ayoq localayoq = (ayoq)this.jdField_a_of_type_Azih.c.get(paramString);
        if ((localayoq != null) && (localayoq.d))
        {
          localayoq.h += 1;
          localayoq.b((int)NetConnInfoCenter.getServerTime());
          j = this.jdField_a_of_type_JavaUtilList.size();
          i = 0;
          if (i < j)
          {
            if (localayoq != this.jdField_a_of_type_JavaUtilList.get(i)) {
              break;
            }
            localazin.jdField_a_of_type_JavaUtilList.remove(i);
          }
          localazin.jdField_a_of_type_JavaUtilList.add(0, localayoq);
          localazin.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
          a(localazin.jdField_a_of_type_JavaUtilList, localazin.jdField_a_of_type_Boolean, 0, false);
        }
      } while (!this.jdField_b_of_type_JavaLangString.equals(paramString));
      paramString = (azin)this.jdField_a_of_type_Azih.d.get(paramString + this.jdField_a_of_type_Long);
    } while ((paramString == null) || (paramString.jdField_a_of_type_JavaUtilList == null));
    boolean bool = paramString.jdField_a_of_type_Boolean;
    int j = this.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        if ((!((ayoq)this.jdField_a_of_type_JavaUtilList.get(i)).d) && (paramayoq.a() >= ((ayoq)this.jdField_a_of_type_JavaUtilList.get(i)).a()))
        {
          paramString.jdField_a_of_type_JavaUtilList.add(i, paramayoq);
          paramString.jdField_a_of_type_JavaUtilMap.put(paramayoq.jdField_b_of_type_JavaLangString, paramayoq);
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
        paramString.jdField_a_of_type_JavaUtilList.add(paramayoq);
        paramString.jdField_a_of_type_JavaUtilMap.put(paramayoq.jdField_b_of_type_JavaLangString, paramayoq);
        a(paramString.jdField_a_of_type_JavaUtilList, paramString.jdField_a_of_type_Boolean, 0, false);
      }
      i += 1;
    }
  }
  
  public void a(aysd paramaysd)
  {
    this.jdField_a_of_type_Aysd = paramaysd;
  }
  
  public void a(List<ayoq> paramList, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
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
    } while ((!paramBoolean1) || (!this.jdField_a_of_type_Azih.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Long)) || (this.jdField_a_of_type_Aysd == null));
    this.jdField_a_of_type_Aysd.d(7);
  }
  
  public void a(List<ayoq> paramList, boolean paramBoolean, String paramString, long paramLong)
  {
    if ((!this.jdField_b_of_type_JavaLangString.equals(paramString)) || (this.jdField_a_of_type_Long != paramLong)) {}
    do
    {
      return;
      if (paramList != null) {
        break;
      }
      if (this.jdField_a_of_type_Aysd != null) {
        this.jdField_a_of_type_Aysd.d(3);
      }
      apcb.a(2131632075);
    } while (!this.jdField_a_of_type_JavaUtilList.isEmpty());
    b(1);
    return;
    if (this.jdField_a_of_type_Aysd != null) {
      this.jdField_a_of_type_Aysd.d(4);
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
  
  public void a(boolean paramBoolean, ayoq paramayoq)
  {
    if (this.jdField_b_of_type_JavaUtilList == null) {
      return;
    }
    if (paramayoq == null) {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "onSelected. fileInfo is null.");
    }
    if (paramBoolean) {
      if (!this.jdField_b_of_type_JavaUtilList.contains(paramayoq)) {
        this.jdField_b_of_type_JavaUtilList.add(paramayoq);
      }
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      this.jdField_b_of_type_JavaUtilList.remove(paramayoq);
    }
  }
  
  public boolean a(ayoq paramayoq)
  {
    if ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.isEmpty())) {
      return false;
    }
    return this.jdField_b_of_type_JavaUtilList.contains(paramayoq);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Azih != null) {
      this.jdField_a_of_type_Azih.unregisterObserver(this);
    }
    if (this.jdField_b_of_type_JavaUtilList != null) {
      this.jdField_b_of_type_JavaUtilList.clear();
    }
  }
  
  protected void b(int paramInt)
  {
    if (this.jdField_a_of_type_Aysd != null) {
      this.jdField_a_of_type_Aysd.c(paramInt);
    }
  }
  
  public void b(ayoq paramayoq)
  {
    if (paramayoq == null) {}
    label146:
    do
    {
      do
      {
        do
        {
          ayse localayse;
          do
          {
            return;
            switch (paramayoq.jdField_e_of_type_Int)
            {
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            default: 
              if ((!this.jdField_b_of_type_JavaLangString.equals(paramayoq.f)) && (this.jdField_a_of_type_Long == 0L)) {
                break label146;
              }
              localayse = (ayse)this.jdField_a_of_type_JavaUtilMap.get(paramayoq.a);
            }
          } while ((localayse == null) || (!localayse.a.a.equals(paramayoq.a)));
          localayse.a = paramayoq;
          localayse.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Boolean);
          paramayoq = (ayoq)this.jdField_a_of_type_Azih.c.get(paramayoq.f);
        } while (paramayoq == null);
        paramayoq = (ayse)this.jdField_a_of_type_JavaUtilMap.get(paramayoq.a);
      } while (paramayoq == null);
      paramayoq.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Boolean);
      return;
    } while (this.jdField_a_of_type_JavaUtilMap.remove(paramayoq.a) == null);
    this.jdField_c_of_type_Boolean = false;
    notifyDataSetChanged();
  }
  
  public void c(ayoq paramayoq) {}
  
  public void d(ayoq paramayoq)
  {
    Object localObject;
    azin localazin;
    if ((paramayoq.jdField_c_of_type_Boolean) && (paramayoq.jdField_e_of_type_Int == 6))
    {
      localObject = (ayoq)this.jdField_a_of_type_Azih.c.get(paramayoq.f);
      if ((localObject == null) || (!this.jdField_b_of_type_JavaLangString.equals(((ayoq)localObject).f)) || (!((ayoq)localObject).d)) {
        break label251;
      }
      localazin = (azin)this.jdField_a_of_type_Azih.d.get(((ayoq)localObject).f + this.jdField_a_of_type_Long);
      if ((localazin != null) && (localazin.jdField_a_of_type_JavaUtilList != null)) {
        break label121;
      }
    }
    label121:
    label251:
    do
    {
      return;
      if (TextUtils.isEmpty(paramayoq.c()))
      {
        if (paramayoq.jdField_b_of_type_Long != 0L) {
          break;
        }
        paramayoq.jdField_e_of_type_JavaLangString = babh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_b_of_type_Long + "", 1, 0);
      }
      localazin.jdField_a_of_type_JavaUtilList.remove(localObject);
      ((ayoq)localObject).b(paramayoq.a());
      ((ayoq)localObject).h += 1;
      localazin.jdField_a_of_type_JavaUtilList.add(0, localObject);
      a(localazin.jdField_a_of_type_JavaUtilList, localazin.jdField_a_of_type_Boolean, 0, false);
      localazin.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
      if (!this.jdField_b_of_type_JavaLangString.equals(paramayoq.f)) {
        break label618;
      }
      localObject = (azin)this.jdField_a_of_type_Azih.d.get(paramayoq.f + this.jdField_a_of_type_Long);
    } while ((localObject == null) || (((azin)localObject).jdField_a_of_type_JavaUtilList == null));
    boolean bool = ((azin)localObject).jdField_a_of_type_Boolean;
    int j = this.jdField_a_of_type_JavaUtilList.size();
    label397:
    int i;
    if (TextUtils.isEmpty(paramayoq.c()))
    {
      if (paramayoq.jdField_b_of_type_Long == 0L) {
        paramayoq.jdField_e_of_type_JavaLangString = babh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_b_of_type_Long + "", 1, 0);
      }
    }
    else
    {
      if (this.jdField_a_of_type_JavaUtilList.size() == 0)
      {
        ((azin)localObject).jdField_a_of_type_JavaUtilList.add(paramayoq);
        ((azin)localObject).jdField_a_of_type_JavaUtilMap.put(paramayoq.jdField_b_of_type_JavaLangString, paramayoq);
      }
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        if ((!((ayoq)this.jdField_a_of_type_JavaUtilList.get(i)).d) && (paramayoq.a() >= ((ayoq)this.jdField_a_of_type_JavaUtilList.get(i)).a()))
        {
          ((azin)localObject).jdField_a_of_type_JavaUtilList.add(i, paramayoq);
          ((azin)localObject).jdField_a_of_type_JavaUtilMap.put(paramayoq.jdField_b_of_type_JavaLangString, paramayoq);
          notifyDataSetChanged();
        }
      }
      else
      {
        ((azin)localObject).jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
        a(((azin)localObject).jdField_a_of_type_JavaUtilList, ((azin)localObject).jdField_a_of_type_Boolean, 0, false);
        return;
        paramayoq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
        break;
        paramayoq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
        break label397;
      }
      if ((i == j - 1) && (bool))
      {
        ((azin)localObject).jdField_a_of_type_JavaUtilList.add(paramayoq);
        ((azin)localObject).jdField_a_of_type_JavaUtilMap.put(paramayoq.jdField_b_of_type_JavaLangString, paramayoq);
      }
      i += 1;
    }
    label618:
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void e(ayoq paramayoq)
  {
    if ((paramayoq.d) && ("/".equals(this.jdField_b_of_type_JavaLangString)) && (this.jdField_a_of_type_Long == 0L))
    {
      paramayoq.a = UUID.randomUUID();
      this.jdField_a_of_type_Azih.b.put(paramayoq.a, paramayoq);
      this.jdField_a_of_type_Azih.c.put(paramayoq.jdField_b_of_type_JavaLangString, paramayoq);
      azin localazin = (azin)this.jdField_a_of_type_Azih.d.get(this.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_Long);
      if (localazin != null)
      {
        if ((localazin.jdField_a_of_type_JavaUtilList != null) && (localazin.jdField_a_of_type_JavaUtilMap != null))
        {
          localazin.jdField_a_of_type_JavaUtilList.add(0, paramayoq);
          localazin.jdField_a_of_type_JavaUtilMap.put(paramayoq.jdField_b_of_type_JavaLangString, paramayoq);
        }
        this.jdField_a_of_type_Azih.c.put(paramayoq.jdField_b_of_type_JavaLangString, paramayoq);
        a(localazin.jdField_a_of_type_JavaUtilList, localazin.jdField_a_of_type_Boolean, 0, false);
        localazin.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
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
    ayoq localayoq = (ayoq)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (paramView == null)
    {
      paramViewGroup = new ayse(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_Long, 2131494922, this.jdField_c_of_type_Int);
      paramViewGroup.a(this);
      paramView = paramViewGroup.b;
      if (paramView == null) {
        return null;
      }
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilMap.put(localayoq.a, paramViewGroup);
      if (paramViewGroup != null)
      {
        paramViewGroup.a = localayoq;
        paramViewGroup.a(this.d);
        paramViewGroup.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if ((!this.d) || (!a(localayoq))) {
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
        if (!(paramViewGroup instanceof ayse)) {
          break label250;
        }
        paramViewGroup = (ayse)paramViewGroup;
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
      if ((this.jdField_a_of_type_Int == this.jdField_b_of_type_Int - 2) && (this.jdField_a_of_type_Azih != null))
      {
        if (!this.jdField_a_of_type_Azih.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Long)) {
          break label88;
        }
        if (this.jdField_a_of_type_Aysd != null) {
          this.jdField_a_of_type_Aysd.d(8);
        }
      }
      label88:
      do
      {
        return;
        this.jdField_a_of_type_Aysd.d(7);
      } while (azjg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_Long) == 0);
      this.jdField_a_of_type_Azih.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Long);
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ayso
 * JD-Core Version:    0.7.0.1
 */