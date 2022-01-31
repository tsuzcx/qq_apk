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

public class bbrp
  extends BaseAdapter
  implements Handler.Callback, bbot, bbrk, bhpo
{
  public static String a;
  public int a;
  public long a;
  private Context jdField_a_of_type_AndroidContentContext;
  public Handler a;
  private bbre jdField_a_of_type_Bbre;
  private bcil jdField_a_of_type_Bcil;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopFileTransferManager jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager;
  private List<bbnr> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map<UUID, bbrf> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  public int b;
  private long jdField_b_of_type_Long;
  public String b;
  private List<bbnr> jdField_b_of_type_JavaUtilList = new ArrayList(20);
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  
  static
  {
    jdField_a_of_type_JavaLangString = "TroopFileExpandableListAdapter<QFile>";
  }
  
  public bbrp(QQAppInterface paramQQAppInterface, Context paramContext, long paramLong, String paramString, int paramInt)
  {
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_b_of_type_Long = paramLong;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
    this.jdField_a_of_type_Bcil = bcil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
    this.jdField_a_of_type_Bcil.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    if (!this.jdField_a_of_type_Bcil.a(this)) {
      this.jdField_a_of_type_Bcil.registerObserver(this);
    }
  }
  
  private List<bbnr> a(List<bbnr> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return paramList;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bbnr localbbnr = (bbnr)paramList.next();
      if ((TextUtils.isEmpty(localbbnr.jdField_b_of_type_JavaLangString)) || (!localbbnr.jdField_b_of_type_JavaLangString.contains("online_doc_folder_"))) {
        localArrayList.add(localbbnr);
      }
    }
    return localArrayList;
  }
  
  public List<bbnr> a()
  {
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  public void a()
  {
    int i;
    int j;
    if (this.jdField_a_of_type_Bbre != null)
    {
      i = this.jdField_a_of_type_Bbre.d();
      j = this.jdField_a_of_type_Bbre.e();
    }
    for (;;)
    {
      if ((i > j - 1) || (i >= this.jdField_a_of_type_JavaUtilList.size())) {
        return;
      }
      Object localObject = (bbnr)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localObject == null) {}
      for (;;)
      {
        i += 1;
        break;
        localObject = (bbrf)this.jdField_a_of_type_JavaUtilMap.get(((bbnr)localObject).a);
        if (localObject != null)
        {
          ((bbrf)localObject).b(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          ((bbrf)localObject).a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
    boolean bool = bdee.g(this.jdField_a_of_type_AndroidContentContext);
    if ((bool) && (this.jdField_a_of_type_Bcil.a(paramInt1, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Long)))
    {
      paramInt1 = 1;
      localObject = (bcir)this.jdField_a_of_type_Bcil.d.get(this.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_Long);
      if (localObject == null) {
        break label169;
      }
    }
    label169:
    for (Object localObject = ((bcir)localObject).jdField_a_of_type_JavaUtilList;; localObject = null)
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
      bcjk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
      return;
    }
  }
  
  public void a(bbnr parambbnr)
  {
    if ((parambbnr.jdField_e_of_type_Int == 2) || (parambbnr.jdField_e_of_type_Int == 3)) {
      return;
    }
    int j = this.jdField_a_of_type_JavaUtilList.size();
    bbnr localbbnr = (bbnr)this.jdField_a_of_type_Bcil.c.get(parambbnr.f);
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        if ((this.jdField_a_of_type_JavaUtilList.get(i) == null) || (!((bbnr)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_b_of_type_JavaLangString.equals(parambbnr.jdField_b_of_type_JavaLangString))) {
          break label451;
        }
        bcir localbcir = (bcir)this.jdField_a_of_type_Bcil.d.get(this.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_Long);
        if (localbcir == null) {
          break label451;
        }
        if ((localbcir.jdField_a_of_type_JavaUtilList != null) && (localbcir.jdField_a_of_type_JavaUtilMap != null))
        {
          localbcir.jdField_a_of_type_JavaUtilMap.remove(((bbnr)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_b_of_type_JavaLangString);
          if (i >= localbcir.jdField_a_of_type_JavaUtilList.size()) {
            break label421;
          }
          parambbnr = (bbnr)localbcir.jdField_a_of_type_JavaUtilList.remove(i);
          if ((parambbnr != null) && (parambbnr.jdField_e_of_type_Int != 12) && (localbbnr != null)) {
            localbbnr.h -= 1;
          }
          if ((parambbnr != null) && (parambbnr.jdField_e_of_type_Int != 12)) {
            localbcir.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
          }
          this.jdField_c_of_type_Boolean = false;
          a(localbcir.jdField_a_of_type_JavaUtilList, localbcir.jdField_a_of_type_Boolean, 0, false);
        }
      }
      for (;;)
      {
        if ((localbbnr == null) || (!"/".equals(this.jdField_b_of_type_JavaLangString)) || (this.jdField_a_of_type_Long != 0L) || (!localbbnr.d)) {
          break label449;
        }
        localbbnr.b((int)NetConnInfoCenter.getServerTime());
        parambbnr = (bcir)this.jdField_a_of_type_Bcil.d.get(localbbnr.f + this.jdField_a_of_type_Long);
        if (parambbnr == null) {
          break;
        }
        if (parambbnr.jdField_a_of_type_JavaUtilList != null)
        {
          parambbnr.jdField_a_of_type_JavaUtilList.remove(localbbnr);
          parambbnr.jdField_a_of_type_JavaUtilList.add(0, localbbnr);
        }
        parambbnr.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
        a(parambbnr.jdField_a_of_type_JavaUtilList, parambbnr.jdField_a_of_type_Boolean, 0, false);
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
  
  public void a(bbnr parambbnr, String paramString)
  {
    if (parambbnr == null) {}
    do
    {
      do
      {
        bcir localbcir;
        do
        {
          return;
          if (!this.jdField_b_of_type_JavaLangString.equals("/")) {
            break;
          }
          localbcir = (bcir)this.jdField_a_of_type_Bcil.d.get("/" + this.jdField_a_of_type_Long);
        } while ((localbcir == null) || (localbcir.jdField_a_of_type_JavaUtilList == null));
        bbnr localbbnr = (bbnr)this.jdField_a_of_type_Bcil.c.get(paramString);
        if ((localbbnr != null) && (localbbnr.d))
        {
          localbbnr.h += 1;
          localbbnr.b((int)NetConnInfoCenter.getServerTime());
          j = this.jdField_a_of_type_JavaUtilList.size();
          i = 0;
          if (i < j)
          {
            if (localbbnr != this.jdField_a_of_type_JavaUtilList.get(i)) {
              break;
            }
            localbcir.jdField_a_of_type_JavaUtilList.remove(i);
          }
          localbcir.jdField_a_of_type_JavaUtilList.add(0, localbbnr);
          localbcir.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
          a(localbcir.jdField_a_of_type_JavaUtilList, localbcir.jdField_a_of_type_Boolean, 0, false);
        }
      } while (!this.jdField_b_of_type_JavaLangString.equals(paramString));
      paramString = (bcir)this.jdField_a_of_type_Bcil.d.get(paramString + this.jdField_a_of_type_Long);
    } while ((paramString == null) || (paramString.jdField_a_of_type_JavaUtilList == null));
    boolean bool = paramString.jdField_a_of_type_Boolean;
    int j = this.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        if ((!((bbnr)this.jdField_a_of_type_JavaUtilList.get(i)).d) && (parambbnr.a() >= ((bbnr)this.jdField_a_of_type_JavaUtilList.get(i)).a()))
        {
          paramString.jdField_a_of_type_JavaUtilList.add(i, parambbnr);
          paramString.jdField_a_of_type_JavaUtilMap.put(parambbnr.jdField_b_of_type_JavaLangString, parambbnr);
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
        paramString.jdField_a_of_type_JavaUtilList.add(parambbnr);
        paramString.jdField_a_of_type_JavaUtilMap.put(parambbnr.jdField_b_of_type_JavaLangString, parambbnr);
        a(paramString.jdField_a_of_type_JavaUtilList, paramString.jdField_a_of_type_Boolean, 0, false);
      }
      i += 1;
    }
  }
  
  public void a(bbre parambbre)
  {
    this.jdField_a_of_type_Bbre = parambbre;
  }
  
  public void a(List<bbnr> paramList, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
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
    } while ((!paramBoolean1) || (!this.jdField_a_of_type_Bcil.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Long)) || (this.jdField_a_of_type_Bbre == null));
    this.jdField_a_of_type_Bbre.d(7);
  }
  
  public void a(List<bbnr> paramList, boolean paramBoolean, String paramString, long paramLong)
  {
    if ((!this.jdField_b_of_type_JavaLangString.equals(paramString)) || (this.jdField_a_of_type_Long != paramLong)) {}
    do
    {
      return;
      if (paramList != null) {
        break;
      }
      if (this.jdField_a_of_type_Bbre != null) {
        this.jdField_a_of_type_Bbre.d(3);
      }
      armz.a(2131697982);
    } while (!this.jdField_a_of_type_JavaUtilList.isEmpty());
    b(1);
    return;
    if (this.jdField_a_of_type_Bbre != null) {
      this.jdField_a_of_type_Bbre.d(4);
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
  
  public void a(boolean paramBoolean, bbnr parambbnr)
  {
    if (this.jdField_b_of_type_JavaUtilList == null) {
      return;
    }
    if (parambbnr == null) {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "onSelected. fileInfo is null.");
    }
    if (paramBoolean) {
      if (!this.jdField_b_of_type_JavaUtilList.contains(parambbnr)) {
        this.jdField_b_of_type_JavaUtilList.add(parambbnr);
      }
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      this.jdField_b_of_type_JavaUtilList.remove(parambbnr);
    }
  }
  
  public boolean a(bbnr parambbnr)
  {
    if ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.isEmpty())) {
      return false;
    }
    return this.jdField_b_of_type_JavaUtilList.contains(parambbnr);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bcil != null) {
      this.jdField_a_of_type_Bcil.unregisterObserver(this);
    }
    if (this.jdField_b_of_type_JavaUtilList != null) {
      this.jdField_b_of_type_JavaUtilList.clear();
    }
  }
  
  protected void b(int paramInt)
  {
    if (this.jdField_a_of_type_Bbre != null) {
      this.jdField_a_of_type_Bbre.c(paramInt);
    }
  }
  
  public void b(bbnr parambbnr)
  {
    if (parambbnr == null) {}
    label146:
    do
    {
      do
      {
        do
        {
          bbrf localbbrf;
          do
          {
            return;
            switch (parambbnr.jdField_e_of_type_Int)
            {
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            default: 
              if ((!this.jdField_b_of_type_JavaLangString.equals(parambbnr.f)) && (this.jdField_a_of_type_Long == 0L)) {
                break label146;
              }
              localbbrf = (bbrf)this.jdField_a_of_type_JavaUtilMap.get(parambbnr.a);
            }
          } while ((localbbrf == null) || (!localbbrf.a.a.equals(parambbnr.a)));
          localbbrf.a = parambbnr;
          localbbrf.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Boolean);
          parambbnr = (bbnr)this.jdField_a_of_type_Bcil.c.get(parambbnr.f);
        } while (parambbnr == null);
        parambbnr = (bbrf)this.jdField_a_of_type_JavaUtilMap.get(parambbnr.a);
      } while (parambbnr == null);
      parambbnr.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Boolean);
      return;
    } while (this.jdField_a_of_type_JavaUtilMap.remove(parambbnr.a) == null);
    this.jdField_c_of_type_Boolean = false;
    notifyDataSetChanged();
  }
  
  public void c(bbnr parambbnr) {}
  
  public void d(bbnr parambbnr)
  {
    Object localObject;
    bcir localbcir;
    if ((parambbnr.jdField_c_of_type_Boolean) && (parambbnr.jdField_e_of_type_Int == 6))
    {
      localObject = (bbnr)this.jdField_a_of_type_Bcil.c.get(parambbnr.f);
      if ((localObject == null) || (!this.jdField_b_of_type_JavaLangString.equals(((bbnr)localObject).f)) || (!((bbnr)localObject).d)) {
        break label251;
      }
      localbcir = (bcir)this.jdField_a_of_type_Bcil.d.get(((bbnr)localObject).f + this.jdField_a_of_type_Long);
      if ((localbcir != null) && (localbcir.jdField_a_of_type_JavaUtilList != null)) {
        break label121;
      }
    }
    label121:
    label251:
    do
    {
      return;
      if (TextUtils.isEmpty(parambbnr.c()))
      {
        if (parambbnr.jdField_b_of_type_Long != 0L) {
          break;
        }
        parambbnr.jdField_e_of_type_JavaLangString = bdbt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_b_of_type_Long + "", 1, 0);
      }
      localbcir.jdField_a_of_type_JavaUtilList.remove(localObject);
      ((bbnr)localObject).b(parambbnr.a());
      ((bbnr)localObject).h += 1;
      localbcir.jdField_a_of_type_JavaUtilList.add(0, localObject);
      a(localbcir.jdField_a_of_type_JavaUtilList, localbcir.jdField_a_of_type_Boolean, 0, false);
      localbcir.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
      if (!this.jdField_b_of_type_JavaLangString.equals(parambbnr.f)) {
        break label618;
      }
      localObject = (bcir)this.jdField_a_of_type_Bcil.d.get(parambbnr.f + this.jdField_a_of_type_Long);
    } while ((localObject == null) || (((bcir)localObject).jdField_a_of_type_JavaUtilList == null));
    boolean bool = ((bcir)localObject).jdField_a_of_type_Boolean;
    int j = this.jdField_a_of_type_JavaUtilList.size();
    label397:
    int i;
    if (TextUtils.isEmpty(parambbnr.c()))
    {
      if (parambbnr.jdField_b_of_type_Long == 0L) {
        parambbnr.jdField_e_of_type_JavaLangString = bdbt.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_b_of_type_Long + "", 1, 0);
      }
    }
    else
    {
      if (this.jdField_a_of_type_JavaUtilList.size() == 0)
      {
        ((bcir)localObject).jdField_a_of_type_JavaUtilList.add(parambbnr);
        ((bcir)localObject).jdField_a_of_type_JavaUtilMap.put(parambbnr.jdField_b_of_type_JavaLangString, parambbnr);
      }
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        if ((!((bbnr)this.jdField_a_of_type_JavaUtilList.get(i)).d) && (parambbnr.a() >= ((bbnr)this.jdField_a_of_type_JavaUtilList.get(i)).a()))
        {
          ((bcir)localObject).jdField_a_of_type_JavaUtilList.add(i, parambbnr);
          ((bcir)localObject).jdField_a_of_type_JavaUtilMap.put(parambbnr.jdField_b_of_type_JavaLangString, parambbnr);
          notifyDataSetChanged();
        }
      }
      else
      {
        ((bcir)localObject).jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
        a(((bcir)localObject).jdField_a_of_type_JavaUtilList, ((bcir)localObject).jdField_a_of_type_Boolean, 0, false);
        return;
        parambbnr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
        break;
        parambbnr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
        break label397;
      }
      if ((i == j - 1) && (bool))
      {
        ((bcir)localObject).jdField_a_of_type_JavaUtilList.add(parambbnr);
        ((bcir)localObject).jdField_a_of_type_JavaUtilMap.put(parambbnr.jdField_b_of_type_JavaLangString, parambbnr);
      }
      i += 1;
    }
    label618:
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void e(bbnr parambbnr)
  {
    if ((parambbnr.d) && ("/".equals(this.jdField_b_of_type_JavaLangString)) && (this.jdField_a_of_type_Long == 0L))
    {
      parambbnr.a = UUID.randomUUID();
      this.jdField_a_of_type_Bcil.b.put(parambbnr.a, parambbnr);
      this.jdField_a_of_type_Bcil.c.put(parambbnr.jdField_b_of_type_JavaLangString, parambbnr);
      bcir localbcir = (bcir)this.jdField_a_of_type_Bcil.d.get(this.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_Long);
      if (localbcir != null)
      {
        if ((localbcir.jdField_a_of_type_JavaUtilList != null) && (localbcir.jdField_a_of_type_JavaUtilMap != null))
        {
          localbcir.jdField_a_of_type_JavaUtilList.add(0, parambbnr);
          localbcir.jdField_a_of_type_JavaUtilMap.put(parambbnr.jdField_b_of_type_JavaLangString, parambbnr);
        }
        this.jdField_a_of_type_Bcil.c.put(parambbnr.jdField_b_of_type_JavaLangString, parambbnr);
        a(localbcir.jdField_a_of_type_JavaUtilList, localbcir.jdField_a_of_type_Boolean, 0, false);
        localbcir.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
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
    bbnr localbbnr = (bbnr)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (paramView == null)
    {
      paramViewGroup = new bbrf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_Long, 2131560670, this.jdField_c_of_type_Int);
      paramViewGroup.a(this);
      paramView = paramViewGroup.b;
      if (paramView == null) {
        return null;
      }
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilMap.put(localbbnr.a, paramViewGroup);
      if (paramViewGroup != null)
      {
        paramViewGroup.a = localbbnr;
        paramViewGroup.a(this.d);
        paramViewGroup.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if ((!this.d) || (!a(localbbnr))) {
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
        if (!(paramViewGroup instanceof bbrf)) {
          break label250;
        }
        paramViewGroup = (bbrf)paramViewGroup;
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
      if ((this.jdField_a_of_type_Int == this.jdField_b_of_type_Int - 2) && (this.jdField_a_of_type_Bcil != null))
      {
        if (!this.jdField_a_of_type_Bcil.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Long)) {
          break label88;
        }
        if (this.jdField_a_of_type_Bbre != null) {
          this.jdField_a_of_type_Bbre.d(8);
        }
      }
      label88:
      do
      {
        return;
        this.jdField_a_of_type_Bbre.d(7);
      } while (bcjk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_Long) == 0);
      this.jdField_a_of_type_Bcil.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Long);
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbrp
 * JD-Core Version:    0.7.0.1
 */