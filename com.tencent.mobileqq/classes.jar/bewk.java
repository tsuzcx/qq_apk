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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class bewk
  extends BaseAdapter
  implements Handler.Callback, betn, bewf, bkhe
{
  public static String a;
  public int a;
  public long a;
  private Context jdField_a_of_type_AndroidContentContext;
  public Handler a;
  private bevz jdField_a_of_type_Bevz;
  private bewf jdField_a_of_type_Bewf;
  private bfrm jdField_a_of_type_Bfrm;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopFileTransferManager jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager;
  private List<besl> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map<UUID, bewa> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  public int b;
  private long jdField_b_of_type_Long;
  public String b;
  private List<besl> jdField_b_of_type_JavaUtilList = new ArrayList(20);
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  
  static
  {
    jdField_a_of_type_JavaLangString = "TroopFileExpandableListAdapter<QFile>";
  }
  
  public bewk(QQAppInterface paramQQAppInterface, Context paramContext, long paramLong, String paramString, int paramInt)
  {
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_b_of_type_Long = paramLong;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
    this.jdField_a_of_type_Bfrm = bfrm.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
    this.jdField_a_of_type_Bfrm.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    if (!this.jdField_a_of_type_Bfrm.a(this)) {
      this.jdField_a_of_type_Bfrm.registerObserver(this);
    }
  }
  
  private List<besl> a(List<besl> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return paramList;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      besl localbesl = (besl)paramList.next();
      if ((TextUtils.isEmpty(localbesl.jdField_b_of_type_JavaLangString)) || (!localbesl.jdField_b_of_type_JavaLangString.contains("online_doc_folder_"))) {
        localArrayList.add(localbesl);
      }
    }
    return localArrayList;
  }
  
  public List<besl> a()
  {
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  public void a()
  {
    int i;
    int j;
    if (this.jdField_a_of_type_Bevz != null)
    {
      i = this.jdField_a_of_type_Bevz.d();
      j = this.jdField_a_of_type_Bevz.e();
    }
    for (;;)
    {
      if ((i > j - 1) || (i >= this.jdField_a_of_type_JavaUtilList.size())) {
        return;
      }
      Object localObject = (besl)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localObject == null) {}
      for (;;)
      {
        i += 1;
        break;
        localObject = (bewa)this.jdField_a_of_type_JavaUtilMap.get(((besl)localObject).a);
        if (localObject != null)
        {
          ((bewa)localObject).b(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          ((bewa)localObject).a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
    boolean bool = bgnt.g(this.jdField_a_of_type_AndroidContentContext);
    if ((bool) && (this.jdField_a_of_type_Bfrm.a(paramInt1, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Long)))
    {
      paramInt1 = 1;
      localObject = (bfrs)this.jdField_a_of_type_Bfrm.d.get(this.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_Long);
      if (localObject == null) {
        break label169;
      }
    }
    label169:
    for (Object localObject = ((bfrs)localObject).jdField_a_of_type_JavaUtilList;; localObject = null)
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
      bfsj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
      return;
    }
  }
  
  public void a(besl parambesl)
  {
    if ((parambesl.jdField_e_of_type_Int == 2) || (parambesl.jdField_e_of_type_Int == 3)) {
      return;
    }
    int j = this.jdField_a_of_type_JavaUtilList.size();
    besl localbesl = (besl)this.jdField_a_of_type_Bfrm.c.get(parambesl.f);
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        if ((this.jdField_a_of_type_JavaUtilList.get(i) == null) || (!((besl)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_b_of_type_JavaLangString.equals(parambesl.jdField_b_of_type_JavaLangString))) {
          break label451;
        }
        bfrs localbfrs = (bfrs)this.jdField_a_of_type_Bfrm.d.get(this.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_Long);
        if (localbfrs == null) {
          break label451;
        }
        if ((localbfrs.jdField_a_of_type_JavaUtilList != null) && (localbfrs.jdField_a_of_type_JavaUtilMap != null))
        {
          localbfrs.jdField_a_of_type_JavaUtilMap.remove(((besl)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_b_of_type_JavaLangString);
          if (i >= localbfrs.jdField_a_of_type_JavaUtilList.size()) {
            break label421;
          }
          parambesl = (besl)localbfrs.jdField_a_of_type_JavaUtilList.remove(i);
          if ((parambesl != null) && (parambesl.jdField_e_of_type_Int != 12) && (localbesl != null)) {
            localbesl.h -= 1;
          }
          if ((parambesl != null) && (parambesl.jdField_e_of_type_Int != 12)) {
            localbfrs.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
          }
          this.jdField_c_of_type_Boolean = false;
          a(localbfrs.jdField_a_of_type_JavaUtilList, localbfrs.jdField_a_of_type_Boolean, 0, false);
        }
      }
      for (;;)
      {
        if ((localbesl == null) || (!"/".equals(this.jdField_b_of_type_JavaLangString)) || (this.jdField_a_of_type_Long != 0L) || (!localbesl.d)) {
          break label449;
        }
        localbesl.b((int)NetConnInfoCenter.getServerTime());
        parambesl = (bfrs)this.jdField_a_of_type_Bfrm.d.get(localbesl.f + this.jdField_a_of_type_Long);
        if (parambesl == null) {
          break;
        }
        if (parambesl.jdField_a_of_type_JavaUtilList != null)
        {
          parambesl.jdField_a_of_type_JavaUtilList.remove(localbesl);
          parambesl.jdField_a_of_type_JavaUtilList.add(0, localbesl);
        }
        parambesl.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
        a(parambesl.jdField_a_of_type_JavaUtilList, parambesl.jdField_a_of_type_Boolean, 0, false);
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
  
  public void a(besl parambesl, String paramString)
  {
    if (parambesl == null) {}
    do
    {
      do
      {
        bfrs localbfrs;
        do
        {
          return;
          if (!this.jdField_b_of_type_JavaLangString.equals("/")) {
            break;
          }
          localbfrs = (bfrs)this.jdField_a_of_type_Bfrm.d.get("/" + this.jdField_a_of_type_Long);
        } while ((localbfrs == null) || (localbfrs.jdField_a_of_type_JavaUtilList == null));
        besl localbesl = (besl)this.jdField_a_of_type_Bfrm.c.get(paramString);
        if ((localbesl != null) && (localbesl.d))
        {
          localbesl.h += 1;
          localbesl.b((int)NetConnInfoCenter.getServerTime());
          j = this.jdField_a_of_type_JavaUtilList.size();
          i = 0;
          if (i < j)
          {
            if (localbesl != this.jdField_a_of_type_JavaUtilList.get(i)) {
              break;
            }
            localbfrs.jdField_a_of_type_JavaUtilList.remove(i);
          }
          localbfrs.jdField_a_of_type_JavaUtilList.add(0, localbesl);
          localbfrs.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
          a(localbfrs.jdField_a_of_type_JavaUtilList, localbfrs.jdField_a_of_type_Boolean, 0, false);
        }
      } while (!this.jdField_b_of_type_JavaLangString.equals(paramString));
      paramString = (bfrs)this.jdField_a_of_type_Bfrm.d.get(paramString + this.jdField_a_of_type_Long);
    } while ((paramString == null) || (paramString.jdField_a_of_type_JavaUtilList == null));
    boolean bool = paramString.jdField_a_of_type_Boolean;
    int j = this.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        if ((!((besl)this.jdField_a_of_type_JavaUtilList.get(i)).d) && (parambesl.a() >= ((besl)this.jdField_a_of_type_JavaUtilList.get(i)).a()))
        {
          paramString.jdField_a_of_type_JavaUtilList.add(i, parambesl);
          paramString.jdField_a_of_type_JavaUtilMap.put(parambesl.jdField_b_of_type_JavaLangString, parambesl);
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
        paramString.jdField_a_of_type_JavaUtilList.add(parambesl);
        paramString.jdField_a_of_type_JavaUtilMap.put(parambesl.jdField_b_of_type_JavaLangString, parambesl);
        a(paramString.jdField_a_of_type_JavaUtilList, paramString.jdField_a_of_type_Boolean, 0, false);
      }
      i += 1;
    }
  }
  
  public void a(bevz parambevz)
  {
    this.jdField_a_of_type_Bevz = parambevz;
  }
  
  public void a(bewf parambewf)
  {
    this.jdField_a_of_type_Bewf = parambewf;
  }
  
  public void a(List<besl> paramList, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
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
    } while ((!paramBoolean1) || (!this.jdField_a_of_type_Bfrm.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Long)) || (this.jdField_a_of_type_Bevz == null));
    this.jdField_a_of_type_Bevz.d(7);
  }
  
  public void a(List<besl> paramList, boolean paramBoolean, String paramString, long paramLong)
  {
    if ((!this.jdField_b_of_type_JavaLangString.equals(paramString)) || (this.jdField_a_of_type_Long != paramLong)) {}
    do
    {
      return;
      if (paramList != null) {
        break;
      }
      if (this.jdField_a_of_type_Bevz != null) {
        this.jdField_a_of_type_Bevz.d(3);
      }
      atvf.a(2131696830);
    } while (!this.jdField_a_of_type_JavaUtilList.isEmpty());
    b(1);
    return;
    if (this.jdField_a_of_type_Bevz != null) {
      this.jdField_a_of_type_Bevz.d(4);
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
  
  public void a(boolean paramBoolean, besl parambesl)
  {
    if (this.jdField_b_of_type_JavaUtilList == null) {
      return;
    }
    if (parambesl == null) {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "onSelected. fileInfo is null.");
    }
    if (paramBoolean) {
      if (!this.jdField_b_of_type_JavaUtilList.contains(parambesl)) {
        this.jdField_b_of_type_JavaUtilList.add(parambesl);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Bewf != null) {
        this.jdField_a_of_type_Bewf.a(paramBoolean, parambesl);
      }
      notifyDataSetChanged();
      return;
      this.jdField_b_of_type_JavaUtilList.remove(parambesl);
    }
  }
  
  public boolean a(besl parambesl)
  {
    if ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.isEmpty())) {
      return false;
    }
    return this.jdField_b_of_type_JavaUtilList.contains(parambesl);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bfrm != null) {
      this.jdField_a_of_type_Bfrm.unregisterObserver(this);
    }
    if (this.jdField_b_of_type_JavaUtilList != null) {
      this.jdField_b_of_type_JavaUtilList.clear();
    }
  }
  
  protected void b(int paramInt)
  {
    if (this.jdField_a_of_type_Bevz != null) {
      this.jdField_a_of_type_Bevz.a(paramInt);
    }
  }
  
  public void b(besl parambesl)
  {
    if (parambesl == null) {}
    label146:
    do
    {
      do
      {
        do
        {
          bewa localbewa;
          do
          {
            return;
            switch (parambesl.jdField_e_of_type_Int)
            {
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            default: 
              if ((!this.jdField_b_of_type_JavaLangString.equals(parambesl.f)) && (this.jdField_a_of_type_Long == 0L)) {
                break label146;
              }
              localbewa = (bewa)this.jdField_a_of_type_JavaUtilMap.get(parambesl.a);
            }
          } while ((localbewa == null) || (!localbewa.a.a.equals(parambesl.a)));
          localbewa.a = parambesl;
          localbewa.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Boolean);
          parambesl = (besl)this.jdField_a_of_type_Bfrm.c.get(parambesl.f);
        } while (parambesl == null);
        parambesl = (bewa)this.jdField_a_of_type_JavaUtilMap.get(parambesl.a);
      } while (parambesl == null);
      parambesl.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Boolean);
      return;
    } while (this.jdField_a_of_type_JavaUtilMap.remove(parambesl.a) == null);
    this.jdField_c_of_type_Boolean = false;
    notifyDataSetChanged();
  }
  
  public void c(besl parambesl) {}
  
  public void d(besl parambesl)
  {
    Object localObject;
    bfrs localbfrs;
    if ((parambesl.jdField_c_of_type_Boolean) && (parambesl.jdField_e_of_type_Int == 6))
    {
      localObject = (besl)this.jdField_a_of_type_Bfrm.c.get(parambesl.f);
      if ((localObject == null) || (!this.jdField_b_of_type_JavaLangString.equals(((besl)localObject).f)) || (!((besl)localObject).d)) {
        break label251;
      }
      localbfrs = (bfrs)this.jdField_a_of_type_Bfrm.d.get(((besl)localObject).f + this.jdField_a_of_type_Long);
      if ((localbfrs != null) && (localbfrs.jdField_a_of_type_JavaUtilList != null)) {
        break label121;
      }
    }
    label121:
    label251:
    do
    {
      return;
      if (TextUtils.isEmpty(parambesl.c()))
      {
        if (parambesl.jdField_b_of_type_Long != 0L) {
          break;
        }
        parambesl.jdField_e_of_type_JavaLangString = bglf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_b_of_type_Long + "", 1, 0);
      }
      localbfrs.jdField_a_of_type_JavaUtilList.remove(localObject);
      ((besl)localObject).b(parambesl.a());
      ((besl)localObject).h += 1;
      localbfrs.jdField_a_of_type_JavaUtilList.add(0, localObject);
      a(localbfrs.jdField_a_of_type_JavaUtilList, localbfrs.jdField_a_of_type_Boolean, 0, false);
      localbfrs.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
      if (!this.jdField_b_of_type_JavaLangString.equals(parambesl.f)) {
        break label618;
      }
      localObject = (bfrs)this.jdField_a_of_type_Bfrm.d.get(parambesl.f + this.jdField_a_of_type_Long);
    } while ((localObject == null) || (((bfrs)localObject).jdField_a_of_type_JavaUtilList == null));
    boolean bool = ((bfrs)localObject).jdField_a_of_type_Boolean;
    int j = this.jdField_a_of_type_JavaUtilList.size();
    label397:
    int i;
    if (TextUtils.isEmpty(parambesl.c()))
    {
      if (parambesl.jdField_b_of_type_Long == 0L) {
        parambesl.jdField_e_of_type_JavaLangString = bglf.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_b_of_type_Long + "", 1, 0);
      }
    }
    else
    {
      if (this.jdField_a_of_type_JavaUtilList.size() == 0)
      {
        ((bfrs)localObject).jdField_a_of_type_JavaUtilList.add(parambesl);
        ((bfrs)localObject).jdField_a_of_type_JavaUtilMap.put(parambesl.jdField_b_of_type_JavaLangString, parambesl);
      }
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        if ((!((besl)this.jdField_a_of_type_JavaUtilList.get(i)).d) && (parambesl.a() >= ((besl)this.jdField_a_of_type_JavaUtilList.get(i)).a()))
        {
          ((bfrs)localObject).jdField_a_of_type_JavaUtilList.add(i, parambesl);
          ((bfrs)localObject).jdField_a_of_type_JavaUtilMap.put(parambesl.jdField_b_of_type_JavaLangString, parambesl);
          notifyDataSetChanged();
        }
      }
      else
      {
        ((bfrs)localObject).jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
        a(((bfrs)localObject).jdField_a_of_type_JavaUtilList, ((bfrs)localObject).jdField_a_of_type_Boolean, 0, false);
        return;
        parambesl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
        break;
        parambesl.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
        break label397;
      }
      if ((i == j - 1) && (bool))
      {
        ((bfrs)localObject).jdField_a_of_type_JavaUtilList.add(parambesl);
        ((bfrs)localObject).jdField_a_of_type_JavaUtilMap.put(parambesl.jdField_b_of_type_JavaLangString, parambesl);
      }
      i += 1;
    }
    label618:
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void e(besl parambesl)
  {
    if ((parambesl.d) && ("/".equals(this.jdField_b_of_type_JavaLangString)) && (this.jdField_a_of_type_Long == 0L))
    {
      parambesl.a = UUID.randomUUID();
      this.jdField_a_of_type_Bfrm.b.put(parambesl.a, parambesl);
      this.jdField_a_of_type_Bfrm.c.put(parambesl.jdField_b_of_type_JavaLangString, parambesl);
      bfrs localbfrs = (bfrs)this.jdField_a_of_type_Bfrm.d.get(this.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_Long);
      if (localbfrs != null)
      {
        if ((localbfrs.jdField_a_of_type_JavaUtilList != null) && (localbfrs.jdField_a_of_type_JavaUtilMap != null))
        {
          localbfrs.jdField_a_of_type_JavaUtilList.add(0, parambesl);
          localbfrs.jdField_a_of_type_JavaUtilMap.put(parambesl.jdField_b_of_type_JavaLangString, parambesl);
        }
        this.jdField_a_of_type_Bfrm.c.put(parambesl.jdField_b_of_type_JavaLangString, parambesl);
        a(localbfrs.jdField_a_of_type_JavaUtilList, localbfrs.jdField_a_of_type_Boolean, 0, false);
        localbfrs.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
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
    Object localObject = null;
    if (paramInt >= this.jdField_a_of_type_JavaUtilList.size()) {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "getView: error. position[" + paramInt + "] fileListSize[" + this.jdField_a_of_type_JavaUtilList.size() + "]");
    }
    besl localbesl = (besl)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (paramView == null)
    {
      bewa localbewa = new bewa(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_Long, 2131560893, this.jdField_c_of_type_Int);
      localbewa.a(this);
      paramView = localbewa.b;
      if (paramView == null)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return localObject;
      }
      paramView.setTag(localbewa);
      localObject = localbewa;
    }
    for (;;)
    {
      label157:
      this.jdField_a_of_type_JavaUtilMap.put(localbesl.a, localObject);
      if (localObject != null)
      {
        ((bewa)localObject).a = localbesl;
        ((bewa)localObject).a(this.d);
        ((bewa)localObject).a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if ((!this.d) || (!a(localbesl))) {
          break label285;
        }
      }
      label285:
      for (boolean bool = true;; bool = false)
      {
        ((bewa)localObject).b(bool);
        ((bewa)localObject).a(this.jdField_b_of_type_Long, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Boolean);
        localObject = paramView;
        break;
        localObject = paramView.getTag();
        if (!(localObject instanceof bewa)) {
          break label291;
        }
        localObject = (bewa)localObject;
        break label157;
      }
      label291:
      localObject = null;
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
      if ((this.jdField_a_of_type_Int == this.jdField_b_of_type_Int - 2) && (this.jdField_a_of_type_Bfrm != null))
      {
        if (!this.jdField_a_of_type_Bfrm.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Long)) {
          break label88;
        }
        if (this.jdField_a_of_type_Bevz != null) {
          this.jdField_a_of_type_Bevz.d(8);
        }
      }
      label88:
      do
      {
        return;
        this.jdField_a_of_type_Bevz.d(7);
      } while (bfsj.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_Long) == 0);
      this.jdField_a_of_type_Bfrm.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Long);
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bewk
 * JD-Core Version:    0.7.0.1
 */