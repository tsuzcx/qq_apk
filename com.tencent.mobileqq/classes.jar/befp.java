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
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class befp
  extends BaseAdapter
  implements Handler.Callback, bece, befk, AbsListView.OnScrollListener
{
  public static String a;
  public int a;
  public long a;
  private Context jdField_a_of_type_AndroidContentContext;
  public Handler a;
  private befe jdField_a_of_type_Befe;
  private befk jdField_a_of_type_Befk;
  private bfbb jdField_a_of_type_Bfbb;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopFileTransferManager jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager;
  private List<bebc> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map<UUID, beff> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  public int b;
  private long jdField_b_of_type_Long;
  public String b;
  private List<bebc> jdField_b_of_type_JavaUtilList = new ArrayList(20);
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  
  static
  {
    jdField_a_of_type_JavaLangString = "TroopFileExpandableListAdapter<QFile>";
  }
  
  public befp(QQAppInterface paramQQAppInterface, Context paramContext, long paramLong, String paramString, int paramInt)
  {
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_b_of_type_Long = paramLong;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
    this.jdField_a_of_type_Bfbb = bfbb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
    this.jdField_a_of_type_Bfbb.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    if (!this.jdField_a_of_type_Bfbb.a(this)) {
      this.jdField_a_of_type_Bfbb.registerObserver(this);
    }
  }
  
  private List<bebc> a(List<bebc> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return paramList;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bebc localbebc = (bebc)paramList.next();
      if ((TextUtils.isEmpty(localbebc.jdField_b_of_type_JavaLangString)) || (!localbebc.jdField_b_of_type_JavaLangString.contains("online_doc_folder_"))) {
        localArrayList.add(localbebc);
      }
    }
    return localArrayList;
  }
  
  public List<bebc> a()
  {
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  public void a()
  {
    int i;
    int j;
    if (this.jdField_a_of_type_Befe != null)
    {
      i = this.jdField_a_of_type_Befe.d();
      j = this.jdField_a_of_type_Befe.e();
    }
    for (;;)
    {
      if ((i > j - 1) || (i >= this.jdField_a_of_type_JavaUtilList.size())) {
        return;
      }
      Object localObject = (bebc)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localObject == null) {}
      for (;;)
      {
        i += 1;
        break;
        localObject = (beff)this.jdField_a_of_type_JavaUtilMap.get(((bebc)localObject).a);
        if (localObject != null)
        {
          ((beff)localObject).b(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          ((beff)localObject).a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
    boolean bool = NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext);
    if ((bool) && (this.jdField_a_of_type_Bfbb.a(paramInt1, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Long)))
    {
      paramInt1 = 1;
      localObject = (bfbh)this.jdField_a_of_type_Bfbb.d.get(this.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_Long);
      if (localObject == null) {
        break label169;
      }
    }
    label169:
    for (Object localObject = ((bfbh)localObject).jdField_a_of_type_JavaUtilList;; localObject = null)
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
      bfby.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
      return;
    }
  }
  
  public void a(bebc parambebc)
  {
    if ((parambebc.jdField_e_of_type_Int == 2) || (parambebc.jdField_e_of_type_Int == 3)) {
      return;
    }
    int j = this.jdField_a_of_type_JavaUtilList.size();
    bebc localbebc = (bebc)this.jdField_a_of_type_Bfbb.c.get(parambebc.f);
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        if ((this.jdField_a_of_type_JavaUtilList.get(i) == null) || (!((bebc)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_b_of_type_JavaLangString.equals(parambebc.jdField_b_of_type_JavaLangString))) {
          break label451;
        }
        bfbh localbfbh = (bfbh)this.jdField_a_of_type_Bfbb.d.get(this.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_Long);
        if (localbfbh == null) {
          break label451;
        }
        if ((localbfbh.jdField_a_of_type_JavaUtilList != null) && (localbfbh.jdField_a_of_type_JavaUtilMap != null))
        {
          localbfbh.jdField_a_of_type_JavaUtilMap.remove(((bebc)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_b_of_type_JavaLangString);
          if (i >= localbfbh.jdField_a_of_type_JavaUtilList.size()) {
            break label421;
          }
          parambebc = (bebc)localbfbh.jdField_a_of_type_JavaUtilList.remove(i);
          if ((parambebc != null) && (parambebc.jdField_e_of_type_Int != 12) && (localbebc != null)) {
            localbebc.h -= 1;
          }
          if ((parambebc != null) && (parambebc.jdField_e_of_type_Int != 12)) {
            localbfbh.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
          }
          this.jdField_c_of_type_Boolean = false;
          a(localbfbh.jdField_a_of_type_JavaUtilList, localbfbh.jdField_a_of_type_Boolean, 0, false);
        }
      }
      for (;;)
      {
        if ((localbebc == null) || (!"/".equals(this.jdField_b_of_type_JavaLangString)) || (this.jdField_a_of_type_Long != 0L) || (!localbebc.d)) {
          break label449;
        }
        localbebc.b((int)NetConnInfoCenter.getServerTime());
        parambebc = (bfbh)this.jdField_a_of_type_Bfbb.d.get(localbebc.f + this.jdField_a_of_type_Long);
        if (parambebc == null) {
          break;
        }
        if (parambebc.jdField_a_of_type_JavaUtilList != null)
        {
          parambebc.jdField_a_of_type_JavaUtilList.remove(localbebc);
          parambebc.jdField_a_of_type_JavaUtilList.add(0, localbebc);
        }
        parambebc.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
        a(parambebc.jdField_a_of_type_JavaUtilList, parambebc.jdField_a_of_type_Boolean, 0, false);
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
  
  public void a(bebc parambebc, String paramString)
  {
    if (parambebc == null) {}
    do
    {
      do
      {
        bfbh localbfbh;
        do
        {
          return;
          if (!this.jdField_b_of_type_JavaLangString.equals("/")) {
            break;
          }
          localbfbh = (bfbh)this.jdField_a_of_type_Bfbb.d.get("/" + this.jdField_a_of_type_Long);
        } while ((localbfbh == null) || (localbfbh.jdField_a_of_type_JavaUtilList == null));
        bebc localbebc = (bebc)this.jdField_a_of_type_Bfbb.c.get(paramString);
        if ((localbebc != null) && (localbebc.d))
        {
          localbebc.h += 1;
          localbebc.b((int)NetConnInfoCenter.getServerTime());
          j = this.jdField_a_of_type_JavaUtilList.size();
          i = 0;
          if (i < j)
          {
            if (localbebc != this.jdField_a_of_type_JavaUtilList.get(i)) {
              break;
            }
            localbfbh.jdField_a_of_type_JavaUtilList.remove(i);
          }
          localbfbh.jdField_a_of_type_JavaUtilList.add(0, localbebc);
          localbfbh.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
          a(localbfbh.jdField_a_of_type_JavaUtilList, localbfbh.jdField_a_of_type_Boolean, 0, false);
        }
      } while (!this.jdField_b_of_type_JavaLangString.equals(paramString));
      paramString = (bfbh)this.jdField_a_of_type_Bfbb.d.get(paramString + this.jdField_a_of_type_Long);
    } while ((paramString == null) || (paramString.jdField_a_of_type_JavaUtilList == null));
    boolean bool = paramString.jdField_a_of_type_Boolean;
    int j = this.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        if ((!((bebc)this.jdField_a_of_type_JavaUtilList.get(i)).d) && (parambebc.a() >= ((bebc)this.jdField_a_of_type_JavaUtilList.get(i)).a()))
        {
          paramString.jdField_a_of_type_JavaUtilList.add(i, parambebc);
          paramString.jdField_a_of_type_JavaUtilMap.put(parambebc.jdField_b_of_type_JavaLangString, parambebc);
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
        paramString.jdField_a_of_type_JavaUtilList.add(parambebc);
        paramString.jdField_a_of_type_JavaUtilMap.put(parambebc.jdField_b_of_type_JavaLangString, parambebc);
        a(paramString.jdField_a_of_type_JavaUtilList, paramString.jdField_a_of_type_Boolean, 0, false);
      }
      i += 1;
    }
  }
  
  public void a(befe parambefe)
  {
    this.jdField_a_of_type_Befe = parambefe;
  }
  
  public void a(befk parambefk)
  {
    this.jdField_a_of_type_Befk = parambefk;
  }
  
  public void a(List<bebc> paramList, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
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
    } while ((!paramBoolean1) || (!this.jdField_a_of_type_Bfbb.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Long)) || (this.jdField_a_of_type_Befe == null));
    this.jdField_a_of_type_Befe.d(7);
  }
  
  public void a(List<bebc> paramList, boolean paramBoolean, String paramString, long paramLong)
  {
    if ((!this.jdField_b_of_type_JavaLangString.equals(paramString)) || (this.jdField_a_of_type_Long != paramLong)) {}
    do
    {
      return;
      if (paramList != null) {
        break;
      }
      if (this.jdField_a_of_type_Befe != null) {
        this.jdField_a_of_type_Befe.d(3);
      }
      aszk.a(2131697020);
    } while (!this.jdField_a_of_type_JavaUtilList.isEmpty());
    b(1);
    return;
    if (this.jdField_a_of_type_Befe != null) {
      this.jdField_a_of_type_Befe.d(4);
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
  
  public void a(boolean paramBoolean, bebc parambebc)
  {
    if (this.jdField_b_of_type_JavaUtilList == null) {
      return;
    }
    if (parambebc == null) {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "onSelected. fileInfo is null.");
    }
    if (paramBoolean) {
      if (!this.jdField_b_of_type_JavaUtilList.contains(parambebc)) {
        this.jdField_b_of_type_JavaUtilList.add(parambebc);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Befk != null) {
        this.jdField_a_of_type_Befk.a(paramBoolean, parambebc);
      }
      notifyDataSetChanged();
      return;
      this.jdField_b_of_type_JavaUtilList.remove(parambebc);
    }
  }
  
  public boolean a(bebc parambebc)
  {
    if ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.isEmpty())) {
      return false;
    }
    return this.jdField_b_of_type_JavaUtilList.contains(parambebc);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bfbb != null) {
      this.jdField_a_of_type_Bfbb.unregisterObserver(this);
    }
    if (this.jdField_b_of_type_JavaUtilList != null) {
      this.jdField_b_of_type_JavaUtilList.clear();
    }
  }
  
  protected void b(int paramInt)
  {
    if (this.jdField_a_of_type_Befe != null) {
      this.jdField_a_of_type_Befe.c(paramInt);
    }
  }
  
  public void b(bebc parambebc)
  {
    if (parambebc == null) {}
    label146:
    do
    {
      do
      {
        do
        {
          beff localbeff;
          do
          {
            return;
            switch (parambebc.jdField_e_of_type_Int)
            {
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            default: 
              if ((!this.jdField_b_of_type_JavaLangString.equals(parambebc.f)) && (this.jdField_a_of_type_Long == 0L)) {
                break label146;
              }
              localbeff = (beff)this.jdField_a_of_type_JavaUtilMap.get(parambebc.a);
            }
          } while ((localbeff == null) || (!localbeff.a.a.equals(parambebc.a)));
          localbeff.a = parambebc;
          localbeff.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Boolean);
          parambebc = (bebc)this.jdField_a_of_type_Bfbb.c.get(parambebc.f);
        } while (parambebc == null);
        parambebc = (beff)this.jdField_a_of_type_JavaUtilMap.get(parambebc.a);
      } while (parambebc == null);
      parambebc.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Boolean);
      return;
    } while (this.jdField_a_of_type_JavaUtilMap.remove(parambebc.a) == null);
    this.jdField_c_of_type_Boolean = false;
    notifyDataSetChanged();
  }
  
  public void c(bebc parambebc) {}
  
  public void d(bebc parambebc)
  {
    Object localObject;
    bfbh localbfbh;
    if ((parambebc.jdField_c_of_type_Boolean) && (parambebc.jdField_e_of_type_Int == 6))
    {
      localObject = (bebc)this.jdField_a_of_type_Bfbb.c.get(parambebc.f);
      if ((localObject == null) || (!this.jdField_b_of_type_JavaLangString.equals(((bebc)localObject).f)) || (!((bebc)localObject).d)) {
        break label251;
      }
      localbfbh = (bfbh)this.jdField_a_of_type_Bfbb.d.get(((bebc)localObject).f + this.jdField_a_of_type_Long);
      if ((localbfbh != null) && (localbfbh.jdField_a_of_type_JavaUtilList != null)) {
        break label121;
      }
    }
    label121:
    label251:
    do
    {
      return;
      if (TextUtils.isEmpty(parambebc.c()))
      {
        if (parambebc.jdField_b_of_type_Long != 0L) {
          break;
        }
        parambebc.jdField_e_of_type_JavaLangString = ContactUtils.getDisplayName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_b_of_type_Long + "", 1, 0);
      }
      localbfbh.jdField_a_of_type_JavaUtilList.remove(localObject);
      ((bebc)localObject).b(parambebc.a());
      ((bebc)localObject).h += 1;
      localbfbh.jdField_a_of_type_JavaUtilList.add(0, localObject);
      a(localbfbh.jdField_a_of_type_JavaUtilList, localbfbh.jdField_a_of_type_Boolean, 0, false);
      localbfbh.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
      if (!this.jdField_b_of_type_JavaLangString.equals(parambebc.f)) {
        break label618;
      }
      localObject = (bfbh)this.jdField_a_of_type_Bfbb.d.get(parambebc.f + this.jdField_a_of_type_Long);
    } while ((localObject == null) || (((bfbh)localObject).jdField_a_of_type_JavaUtilList == null));
    boolean bool = ((bfbh)localObject).jdField_a_of_type_Boolean;
    int j = this.jdField_a_of_type_JavaUtilList.size();
    label397:
    int i;
    if (TextUtils.isEmpty(parambebc.c()))
    {
      if (parambebc.jdField_b_of_type_Long == 0L) {
        parambebc.jdField_e_of_type_JavaLangString = ContactUtils.getDisplayName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_b_of_type_Long + "", 1, 0);
      }
    }
    else
    {
      if (this.jdField_a_of_type_JavaUtilList.size() == 0)
      {
        ((bfbh)localObject).jdField_a_of_type_JavaUtilList.add(parambebc);
        ((bfbh)localObject).jdField_a_of_type_JavaUtilMap.put(parambebc.jdField_b_of_type_JavaLangString, parambebc);
      }
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        if ((!((bebc)this.jdField_a_of_type_JavaUtilList.get(i)).d) && (parambebc.a() >= ((bebc)this.jdField_a_of_type_JavaUtilList.get(i)).a()))
        {
          ((bfbh)localObject).jdField_a_of_type_JavaUtilList.add(i, parambebc);
          ((bfbh)localObject).jdField_a_of_type_JavaUtilMap.put(parambebc.jdField_b_of_type_JavaLangString, parambebc);
          notifyDataSetChanged();
        }
      }
      else
      {
        ((bfbh)localObject).jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
        a(((bfbh)localObject).jdField_a_of_type_JavaUtilList, ((bfbh)localObject).jdField_a_of_type_Boolean, 0, false);
        return;
        parambebc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
        break;
        parambebc.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
        break label397;
      }
      if ((i == j - 1) && (bool))
      {
        ((bfbh)localObject).jdField_a_of_type_JavaUtilList.add(parambebc);
        ((bfbh)localObject).jdField_a_of_type_JavaUtilMap.put(parambebc.jdField_b_of_type_JavaLangString, parambebc);
      }
      i += 1;
    }
    label618:
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void e(bebc parambebc)
  {
    if ((parambebc.d) && ("/".equals(this.jdField_b_of_type_JavaLangString)) && (this.jdField_a_of_type_Long == 0L))
    {
      parambebc.a = UUID.randomUUID();
      this.jdField_a_of_type_Bfbb.b.put(parambebc.a, parambebc);
      this.jdField_a_of_type_Bfbb.c.put(parambebc.jdField_b_of_type_JavaLangString, parambebc);
      bfbh localbfbh = (bfbh)this.jdField_a_of_type_Bfbb.d.get(this.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_Long);
      if (localbfbh != null)
      {
        if ((localbfbh.jdField_a_of_type_JavaUtilList != null) && (localbfbh.jdField_a_of_type_JavaUtilMap != null))
        {
          localbfbh.jdField_a_of_type_JavaUtilList.add(0, parambebc);
          localbfbh.jdField_a_of_type_JavaUtilMap.put(parambebc.jdField_b_of_type_JavaLangString, parambebc);
        }
        this.jdField_a_of_type_Bfbb.c.put(parambebc.jdField_b_of_type_JavaLangString, parambebc);
        a(localbfbh.jdField_a_of_type_JavaUtilList, localbfbh.jdField_a_of_type_Boolean, 0, false);
        localbfbh.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
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
    bebc localbebc = (bebc)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (paramView == null)
    {
      beff localbeff = new beff(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_Long, 2131560804, this.jdField_c_of_type_Int);
      localbeff.a(this);
      paramView = localbeff.b;
      if (paramView == null)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return localObject;
      }
      paramView.setTag(localbeff);
      localObject = localbeff;
    }
    for (;;)
    {
      label157:
      this.jdField_a_of_type_JavaUtilMap.put(localbebc.a, localObject);
      if (localObject != null)
      {
        ((beff)localObject).a = localbebc;
        ((beff)localObject).a(this.d);
        ((beff)localObject).a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if ((!this.d) || (!a(localbebc))) {
          break label285;
        }
      }
      label285:
      for (boolean bool = true;; bool = false)
      {
        ((beff)localObject).b(bool);
        ((beff)localObject).a(this.jdField_b_of_type_Long, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Boolean);
        localObject = paramView;
        break;
        localObject = paramView.getTag();
        if (!(localObject instanceof beff)) {
          break label291;
        }
        localObject = (beff)localObject;
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
      if ((this.jdField_a_of_type_Int == this.jdField_b_of_type_Int - 2) && (this.jdField_a_of_type_Bfbb != null))
      {
        if (!this.jdField_a_of_type_Bfbb.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Long)) {
          break label88;
        }
        if (this.jdField_a_of_type_Befe != null) {
          this.jdField_a_of_type_Befe.d(8);
        }
      }
      label88:
      do
      {
        return;
        this.jdField_a_of_type_Befe.d(7);
      } while (bfby.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_Long) == 0);
      this.jdField_a_of_type_Bfbb.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Long);
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     befp
 * JD-Core Version:    0.7.0.1
 */