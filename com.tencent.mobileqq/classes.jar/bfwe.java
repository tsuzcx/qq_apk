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

public class bfwe
  extends BaseAdapter
  implements Handler.Callback, bfsu, bfvz, blih
{
  public static String a;
  public int a;
  public long a;
  private Context jdField_a_of_type_AndroidContentContext;
  public Handler a;
  private bfvt jdField_a_of_type_Bfvt;
  private bfvz jdField_a_of_type_Bfvz;
  private bgrn jdField_a_of_type_Bgrn;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopFileTransferManager jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager;
  private List<bfrs> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map<UUID, bfvu> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  public int b;
  private long jdField_b_of_type_Long;
  public String b;
  private List<bfrs> jdField_b_of_type_JavaUtilList = new ArrayList(20);
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  
  static
  {
    jdField_a_of_type_JavaLangString = "TroopFileExpandableListAdapter<QFile>";
  }
  
  public bfwe(QQAppInterface paramQQAppInterface, Context paramContext, long paramLong, String paramString, int paramInt)
  {
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_b_of_type_Long = paramLong;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
    this.jdField_a_of_type_Bgrn = bgrn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
    this.jdField_a_of_type_Bgrn.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    if (!this.jdField_a_of_type_Bgrn.a(this)) {
      this.jdField_a_of_type_Bgrn.registerObserver(this);
    }
  }
  
  private List<bfrs> a(List<bfrs> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return paramList;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bfrs localbfrs = (bfrs)paramList.next();
      if ((TextUtils.isEmpty(localbfrs.jdField_b_of_type_JavaLangString)) || (!localbfrs.jdField_b_of_type_JavaLangString.contains("online_doc_folder_"))) {
        localArrayList.add(localbfrs);
      }
    }
    return localArrayList;
  }
  
  public List<bfrs> a()
  {
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  public void a()
  {
    int i;
    int j;
    if (this.jdField_a_of_type_Bfvt != null)
    {
      i = this.jdField_a_of_type_Bfvt.d();
      j = this.jdField_a_of_type_Bfvt.e();
    }
    for (;;)
    {
      if ((i > j - 1) || (i >= this.jdField_a_of_type_JavaUtilList.size())) {
        return;
      }
      Object localObject = (bfrs)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localObject == null) {}
      for (;;)
      {
        i += 1;
        break;
        localObject = (bfvu)this.jdField_a_of_type_JavaUtilMap.get(((bfrs)localObject).a);
        if (localObject != null)
        {
          ((bfvu)localObject).b(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          ((bfvu)localObject).a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
    boolean bool = bhnv.g(this.jdField_a_of_type_AndroidContentContext);
    if ((bool) && (this.jdField_a_of_type_Bgrn.a(paramInt1, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Long)))
    {
      paramInt1 = 1;
      localObject = (bgrt)this.jdField_a_of_type_Bgrn.d.get(this.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_Long);
      if (localObject == null) {
        break label169;
      }
    }
    label169:
    for (Object localObject = ((bgrt)localObject).jdField_a_of_type_JavaUtilList;; localObject = null)
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
      bgsk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
      return;
    }
  }
  
  public void a(bfrs parambfrs)
  {
    if ((parambfrs.jdField_e_of_type_Int == 2) || (parambfrs.jdField_e_of_type_Int == 3)) {
      return;
    }
    int j = this.jdField_a_of_type_JavaUtilList.size();
    bfrs localbfrs = (bfrs)this.jdField_a_of_type_Bgrn.c.get(parambfrs.f);
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        if ((this.jdField_a_of_type_JavaUtilList.get(i) == null) || (!((bfrs)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_b_of_type_JavaLangString.equals(parambfrs.jdField_b_of_type_JavaLangString))) {
          break label451;
        }
        bgrt localbgrt = (bgrt)this.jdField_a_of_type_Bgrn.d.get(this.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_Long);
        if (localbgrt == null) {
          break label451;
        }
        if ((localbgrt.jdField_a_of_type_JavaUtilList != null) && (localbgrt.jdField_a_of_type_JavaUtilMap != null))
        {
          localbgrt.jdField_a_of_type_JavaUtilMap.remove(((bfrs)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_b_of_type_JavaLangString);
          if (i >= localbgrt.jdField_a_of_type_JavaUtilList.size()) {
            break label421;
          }
          parambfrs = (bfrs)localbgrt.jdField_a_of_type_JavaUtilList.remove(i);
          if ((parambfrs != null) && (parambfrs.jdField_e_of_type_Int != 12) && (localbfrs != null)) {
            localbfrs.h -= 1;
          }
          if ((parambfrs != null) && (parambfrs.jdField_e_of_type_Int != 12)) {
            localbgrt.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
          }
          this.jdField_c_of_type_Boolean = false;
          a(localbgrt.jdField_a_of_type_JavaUtilList, localbgrt.jdField_a_of_type_Boolean, 0, false);
        }
      }
      for (;;)
      {
        if ((localbfrs == null) || (!"/".equals(this.jdField_b_of_type_JavaLangString)) || (this.jdField_a_of_type_Long != 0L) || (!localbfrs.d)) {
          break label449;
        }
        localbfrs.b((int)NetConnInfoCenter.getServerTime());
        parambfrs = (bgrt)this.jdField_a_of_type_Bgrn.d.get(localbfrs.f + this.jdField_a_of_type_Long);
        if (parambfrs == null) {
          break;
        }
        if (parambfrs.jdField_a_of_type_JavaUtilList != null)
        {
          parambfrs.jdField_a_of_type_JavaUtilList.remove(localbfrs);
          parambfrs.jdField_a_of_type_JavaUtilList.add(0, localbfrs);
        }
        parambfrs.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
        a(parambfrs.jdField_a_of_type_JavaUtilList, parambfrs.jdField_a_of_type_Boolean, 0, false);
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
  
  public void a(bfrs parambfrs, String paramString)
  {
    if (parambfrs == null) {}
    do
    {
      do
      {
        bgrt localbgrt;
        do
        {
          return;
          if (!this.jdField_b_of_type_JavaLangString.equals("/")) {
            break;
          }
          localbgrt = (bgrt)this.jdField_a_of_type_Bgrn.d.get("/" + this.jdField_a_of_type_Long);
        } while ((localbgrt == null) || (localbgrt.jdField_a_of_type_JavaUtilList == null));
        bfrs localbfrs = (bfrs)this.jdField_a_of_type_Bgrn.c.get(paramString);
        if ((localbfrs != null) && (localbfrs.d))
        {
          localbfrs.h += 1;
          localbfrs.b((int)NetConnInfoCenter.getServerTime());
          j = this.jdField_a_of_type_JavaUtilList.size();
          i = 0;
          if (i < j)
          {
            if (localbfrs != this.jdField_a_of_type_JavaUtilList.get(i)) {
              break;
            }
            localbgrt.jdField_a_of_type_JavaUtilList.remove(i);
          }
          localbgrt.jdField_a_of_type_JavaUtilList.add(0, localbfrs);
          localbgrt.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
          a(localbgrt.jdField_a_of_type_JavaUtilList, localbgrt.jdField_a_of_type_Boolean, 0, false);
        }
      } while (!this.jdField_b_of_type_JavaLangString.equals(paramString));
      paramString = (bgrt)this.jdField_a_of_type_Bgrn.d.get(paramString + this.jdField_a_of_type_Long);
    } while ((paramString == null) || (paramString.jdField_a_of_type_JavaUtilList == null));
    boolean bool = paramString.jdField_a_of_type_Boolean;
    int j = this.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        if ((!((bfrs)this.jdField_a_of_type_JavaUtilList.get(i)).d) && (parambfrs.a() >= ((bfrs)this.jdField_a_of_type_JavaUtilList.get(i)).a()))
        {
          paramString.jdField_a_of_type_JavaUtilList.add(i, parambfrs);
          paramString.jdField_a_of_type_JavaUtilMap.put(parambfrs.jdField_b_of_type_JavaLangString, parambfrs);
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
        paramString.jdField_a_of_type_JavaUtilList.add(parambfrs);
        paramString.jdField_a_of_type_JavaUtilMap.put(parambfrs.jdField_b_of_type_JavaLangString, parambfrs);
        a(paramString.jdField_a_of_type_JavaUtilList, paramString.jdField_a_of_type_Boolean, 0, false);
      }
      i += 1;
    }
  }
  
  public void a(bfvt parambfvt)
  {
    this.jdField_a_of_type_Bfvt = parambfvt;
  }
  
  public void a(bfvz parambfvz)
  {
    this.jdField_a_of_type_Bfvz = parambfvz;
  }
  
  public void a(List<bfrs> paramList, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
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
    } while ((!paramBoolean1) || (!this.jdField_a_of_type_Bgrn.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Long)) || (this.jdField_a_of_type_Bfvt == null));
    this.jdField_a_of_type_Bfvt.d(7);
  }
  
  public void a(List<bfrs> paramList, boolean paramBoolean, String paramString, long paramLong)
  {
    if ((!this.jdField_b_of_type_JavaLangString.equals(paramString)) || (this.jdField_a_of_type_Long != paramLong)) {}
    do
    {
      return;
      if (paramList != null) {
        break;
      }
      if (this.jdField_a_of_type_Bfvt != null) {
        this.jdField_a_of_type_Bfvt.d(3);
      }
      auna.a(2131696879);
    } while (!this.jdField_a_of_type_JavaUtilList.isEmpty());
    b(1);
    return;
    if (this.jdField_a_of_type_Bfvt != null) {
      this.jdField_a_of_type_Bfvt.d(4);
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
  
  public void a(boolean paramBoolean, bfrs parambfrs)
  {
    if (this.jdField_b_of_type_JavaUtilList == null) {
      return;
    }
    if (parambfrs == null) {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "onSelected. fileInfo is null.");
    }
    if (paramBoolean) {
      if (!this.jdField_b_of_type_JavaUtilList.contains(parambfrs)) {
        this.jdField_b_of_type_JavaUtilList.add(parambfrs);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Bfvz != null) {
        this.jdField_a_of_type_Bfvz.a(paramBoolean, parambfrs);
      }
      notifyDataSetChanged();
      return;
      this.jdField_b_of_type_JavaUtilList.remove(parambfrs);
    }
  }
  
  public boolean a(bfrs parambfrs)
  {
    if ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.isEmpty())) {
      return false;
    }
    return this.jdField_b_of_type_JavaUtilList.contains(parambfrs);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bgrn != null) {
      this.jdField_a_of_type_Bgrn.unregisterObserver(this);
    }
    if (this.jdField_b_of_type_JavaUtilList != null) {
      this.jdField_b_of_type_JavaUtilList.clear();
    }
  }
  
  protected void b(int paramInt)
  {
    if (this.jdField_a_of_type_Bfvt != null) {
      this.jdField_a_of_type_Bfvt.a(paramInt);
    }
  }
  
  public void b(bfrs parambfrs)
  {
    if (parambfrs == null) {}
    label146:
    do
    {
      do
      {
        do
        {
          bfvu localbfvu;
          do
          {
            return;
            switch (parambfrs.jdField_e_of_type_Int)
            {
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            default: 
              if ((!this.jdField_b_of_type_JavaLangString.equals(parambfrs.f)) && (this.jdField_a_of_type_Long == 0L)) {
                break label146;
              }
              localbfvu = (bfvu)this.jdField_a_of_type_JavaUtilMap.get(parambfrs.a);
            }
          } while ((localbfvu == null) || (!localbfvu.a.a.equals(parambfrs.a)));
          localbfvu.a = parambfrs;
          localbfvu.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Boolean);
          parambfrs = (bfrs)this.jdField_a_of_type_Bgrn.c.get(parambfrs.f);
        } while (parambfrs == null);
        parambfrs = (bfvu)this.jdField_a_of_type_JavaUtilMap.get(parambfrs.a);
      } while (parambfrs == null);
      parambfrs.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Boolean);
      return;
    } while (this.jdField_a_of_type_JavaUtilMap.remove(parambfrs.a) == null);
    this.jdField_c_of_type_Boolean = false;
    notifyDataSetChanged();
  }
  
  public void c(bfrs parambfrs) {}
  
  public void d(bfrs parambfrs)
  {
    Object localObject;
    bgrt localbgrt;
    if ((parambfrs.jdField_c_of_type_Boolean) && (parambfrs.jdField_e_of_type_Int == 6))
    {
      localObject = (bfrs)this.jdField_a_of_type_Bgrn.c.get(parambfrs.f);
      if ((localObject == null) || (!this.jdField_b_of_type_JavaLangString.equals(((bfrs)localObject).f)) || (!((bfrs)localObject).d)) {
        break label251;
      }
      localbgrt = (bgrt)this.jdField_a_of_type_Bgrn.d.get(((bfrs)localObject).f + this.jdField_a_of_type_Long);
      if ((localbgrt != null) && (localbgrt.jdField_a_of_type_JavaUtilList != null)) {
        break label121;
      }
    }
    label121:
    label251:
    do
    {
      return;
      if (TextUtils.isEmpty(parambfrs.c()))
      {
        if (parambfrs.jdField_b_of_type_Long != 0L) {
          break;
        }
        parambfrs.jdField_e_of_type_JavaLangString = bhlg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_b_of_type_Long + "", 1, 0);
      }
      localbgrt.jdField_a_of_type_JavaUtilList.remove(localObject);
      ((bfrs)localObject).b(parambfrs.a());
      ((bfrs)localObject).h += 1;
      localbgrt.jdField_a_of_type_JavaUtilList.add(0, localObject);
      a(localbgrt.jdField_a_of_type_JavaUtilList, localbgrt.jdField_a_of_type_Boolean, 0, false);
      localbgrt.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
      if (!this.jdField_b_of_type_JavaLangString.equals(parambfrs.f)) {
        break label618;
      }
      localObject = (bgrt)this.jdField_a_of_type_Bgrn.d.get(parambfrs.f + this.jdField_a_of_type_Long);
    } while ((localObject == null) || (((bgrt)localObject).jdField_a_of_type_JavaUtilList == null));
    boolean bool = ((bgrt)localObject).jdField_a_of_type_Boolean;
    int j = this.jdField_a_of_type_JavaUtilList.size();
    label397:
    int i;
    if (TextUtils.isEmpty(parambfrs.c()))
    {
      if (parambfrs.jdField_b_of_type_Long == 0L) {
        parambfrs.jdField_e_of_type_JavaLangString = bhlg.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_b_of_type_Long + "", 1, 0);
      }
    }
    else
    {
      if (this.jdField_a_of_type_JavaUtilList.size() == 0)
      {
        ((bgrt)localObject).jdField_a_of_type_JavaUtilList.add(parambfrs);
        ((bgrt)localObject).jdField_a_of_type_JavaUtilMap.put(parambfrs.jdField_b_of_type_JavaLangString, parambfrs);
      }
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        if ((!((bfrs)this.jdField_a_of_type_JavaUtilList.get(i)).d) && (parambfrs.a() >= ((bfrs)this.jdField_a_of_type_JavaUtilList.get(i)).a()))
        {
          ((bgrt)localObject).jdField_a_of_type_JavaUtilList.add(i, parambfrs);
          ((bgrt)localObject).jdField_a_of_type_JavaUtilMap.put(parambfrs.jdField_b_of_type_JavaLangString, parambfrs);
          notifyDataSetChanged();
        }
      }
      else
      {
        ((bgrt)localObject).jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
        a(((bgrt)localObject).jdField_a_of_type_JavaUtilList, ((bgrt)localObject).jdField_a_of_type_Boolean, 0, false);
        return;
        parambfrs.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
        break;
        parambfrs.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
        break label397;
      }
      if ((i == j - 1) && (bool))
      {
        ((bgrt)localObject).jdField_a_of_type_JavaUtilList.add(parambfrs);
        ((bgrt)localObject).jdField_a_of_type_JavaUtilMap.put(parambfrs.jdField_b_of_type_JavaLangString, parambfrs);
      }
      i += 1;
    }
    label618:
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void e(bfrs parambfrs)
  {
    if ((parambfrs.d) && ("/".equals(this.jdField_b_of_type_JavaLangString)) && (this.jdField_a_of_type_Long == 0L))
    {
      parambfrs.a = UUID.randomUUID();
      this.jdField_a_of_type_Bgrn.b.put(parambfrs.a, parambfrs);
      this.jdField_a_of_type_Bgrn.c.put(parambfrs.jdField_b_of_type_JavaLangString, parambfrs);
      bgrt localbgrt = (bgrt)this.jdField_a_of_type_Bgrn.d.get(this.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_Long);
      if (localbgrt != null)
      {
        if ((localbgrt.jdField_a_of_type_JavaUtilList != null) && (localbgrt.jdField_a_of_type_JavaUtilMap != null))
        {
          localbgrt.jdField_a_of_type_JavaUtilList.add(0, parambfrs);
          localbgrt.jdField_a_of_type_JavaUtilMap.put(parambfrs.jdField_b_of_type_JavaLangString, parambfrs);
        }
        this.jdField_a_of_type_Bgrn.c.put(parambfrs.jdField_b_of_type_JavaLangString, parambfrs);
        a(localbgrt.jdField_a_of_type_JavaUtilList, localbgrt.jdField_a_of_type_Boolean, 0, false);
        localbgrt.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
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
    bfrs localbfrs = (bfrs)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (paramView == null)
    {
      bfvu localbfvu = new bfvu(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_Long, 2131560924, this.jdField_c_of_type_Int);
      localbfvu.a(this);
      paramView = localbfvu.b;
      if (paramView == null)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return localObject;
      }
      paramView.setTag(localbfvu);
      localObject = localbfvu;
    }
    for (;;)
    {
      label157:
      this.jdField_a_of_type_JavaUtilMap.put(localbfrs.a, localObject);
      if (localObject != null)
      {
        ((bfvu)localObject).a = localbfrs;
        ((bfvu)localObject).a(this.d);
        ((bfvu)localObject).a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if ((!this.d) || (!a(localbfrs))) {
          break label285;
        }
      }
      label285:
      for (boolean bool = true;; bool = false)
      {
        ((bfvu)localObject).b(bool);
        ((bfvu)localObject).a(this.jdField_b_of_type_Long, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Boolean);
        localObject = paramView;
        break;
        localObject = paramView.getTag();
        if (!(localObject instanceof bfvu)) {
          break label291;
        }
        localObject = (bfvu)localObject;
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
      if ((this.jdField_a_of_type_Int == this.jdField_b_of_type_Int - 2) && (this.jdField_a_of_type_Bgrn != null))
      {
        if (!this.jdField_a_of_type_Bgrn.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Long)) {
          break label88;
        }
        if (this.jdField_a_of_type_Bfvt != null) {
          this.jdField_a_of_type_Bfvt.d(8);
        }
      }
      label88:
      do
      {
        return;
        this.jdField_a_of_type_Bfvt.d(7);
      } while (bgsk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_Long) == 0);
      this.jdField_a_of_type_Bgrn.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Long);
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfwe
 * JD-Core Version:    0.7.0.1
 */