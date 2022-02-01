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

public class bfms
  extends BaseAdapter
  implements Handler.Callback, bfjh, bfmn, AbsListView.OnScrollListener
{
  public static String a;
  public int a;
  public long a;
  private Context jdField_a_of_type_AndroidContentContext;
  public Handler a;
  private bfmh jdField_a_of_type_Bfmh;
  private bfmn jdField_a_of_type_Bfmn;
  private bgjh jdField_a_of_type_Bgjh;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopFileTransferManager jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager;
  private List<bfif> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map<UUID, bfmi> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  public int b;
  private long jdField_b_of_type_Long;
  public String b;
  private List<bfif> jdField_b_of_type_JavaUtilList = new ArrayList(20);
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  
  static
  {
    jdField_a_of_type_JavaLangString = "TroopFileExpandableListAdapter<QFile>";
  }
  
  public bfms(QQAppInterface paramQQAppInterface, Context paramContext, long paramLong, String paramString, int paramInt)
  {
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_b_of_type_Long = paramLong;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
    this.jdField_a_of_type_Bgjh = bgjh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
    this.jdField_a_of_type_Bgjh.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    if (!this.jdField_a_of_type_Bgjh.a(this)) {
      this.jdField_a_of_type_Bgjh.registerObserver(this);
    }
  }
  
  private List<bfif> a(List<bfif> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return paramList;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      bfif localbfif = (bfif)paramList.next();
      if ((TextUtils.isEmpty(localbfif.jdField_b_of_type_JavaLangString)) || (!localbfif.jdField_b_of_type_JavaLangString.contains("online_doc_folder_"))) {
        localArrayList.add(localbfif);
      }
    }
    return localArrayList;
  }
  
  public List<bfif> a()
  {
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  public void a()
  {
    int i;
    int j;
    if (this.jdField_a_of_type_Bfmh != null)
    {
      i = this.jdField_a_of_type_Bfmh.d();
      j = this.jdField_a_of_type_Bfmh.e();
    }
    for (;;)
    {
      if ((i > j - 1) || (i >= this.jdField_a_of_type_JavaUtilList.size())) {
        return;
      }
      Object localObject = (bfif)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localObject == null) {}
      for (;;)
      {
        i += 1;
        break;
        localObject = (bfmi)this.jdField_a_of_type_JavaUtilMap.get(((bfif)localObject).a);
        if (localObject != null)
        {
          ((bfmi)localObject).b(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          ((bfmi)localObject).a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
    if ((bool) && (this.jdField_a_of_type_Bgjh.a(paramInt1, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Long)))
    {
      paramInt1 = 1;
      localObject = (bgjn)this.jdField_a_of_type_Bgjh.d.get(this.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_Long);
      if (localObject == null) {
        break label169;
      }
    }
    label169:
    for (Object localObject = ((bgjn)localObject).jdField_a_of_type_JavaUtilList;; localObject = null)
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
      bgke.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
      return;
    }
  }
  
  public void a(bfif parambfif)
  {
    if ((parambfif.e == 2) || (parambfif.e == 3)) {
      return;
    }
    int j = this.jdField_a_of_type_JavaUtilList.size();
    bfif localbfif = (bfif)this.jdField_a_of_type_Bgjh.c.get(parambfif.g);
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        if ((this.jdField_a_of_type_JavaUtilList.get(i) == null) || (!((bfif)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_b_of_type_JavaLangString.equals(parambfif.jdField_b_of_type_JavaLangString))) {
          break label451;
        }
        bgjn localbgjn = (bgjn)this.jdField_a_of_type_Bgjh.d.get(this.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_Long);
        if (localbgjn == null) {
          break label451;
        }
        if ((localbgjn.jdField_a_of_type_JavaUtilList != null) && (localbgjn.jdField_a_of_type_JavaUtilMap != null))
        {
          localbgjn.jdField_a_of_type_JavaUtilMap.remove(((bfif)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_b_of_type_JavaLangString);
          if (i >= localbgjn.jdField_a_of_type_JavaUtilList.size()) {
            break label421;
          }
          parambfif = (bfif)localbgjn.jdField_a_of_type_JavaUtilList.remove(i);
          if ((parambfif != null) && (parambfif.e != 12) && (localbfif != null)) {
            localbfif.h -= 1;
          }
          if ((parambfif != null) && (parambfif.e != 12)) {
            localbgjn.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
          }
          this.jdField_c_of_type_Boolean = false;
          a(localbgjn.jdField_a_of_type_JavaUtilList, localbgjn.jdField_a_of_type_Boolean, 0, false);
        }
      }
      for (;;)
      {
        if ((localbfif == null) || (!"/".equals(this.jdField_b_of_type_JavaLangString)) || (this.jdField_a_of_type_Long != 0L) || (!localbfif.d)) {
          break label449;
        }
        localbfif.b((int)NetConnInfoCenter.getServerTime());
        parambfif = (bgjn)this.jdField_a_of_type_Bgjh.d.get(localbfif.g + this.jdField_a_of_type_Long);
        if (parambfif == null) {
          break;
        }
        if (parambfif.jdField_a_of_type_JavaUtilList != null)
        {
          parambfif.jdField_a_of_type_JavaUtilList.remove(localbfif);
          parambfif.jdField_a_of_type_JavaUtilList.add(0, localbfif);
        }
        parambfif.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
        a(parambfif.jdField_a_of_type_JavaUtilList, parambfif.jdField_a_of_type_Boolean, 0, false);
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
  
  public void a(bfif parambfif, String paramString)
  {
    if (parambfif == null) {}
    do
    {
      do
      {
        bgjn localbgjn;
        do
        {
          return;
          if (!this.jdField_b_of_type_JavaLangString.equals("/")) {
            break;
          }
          localbgjn = (bgjn)this.jdField_a_of_type_Bgjh.d.get("/" + this.jdField_a_of_type_Long);
        } while ((localbgjn == null) || (localbgjn.jdField_a_of_type_JavaUtilList == null));
        bfif localbfif = (bfif)this.jdField_a_of_type_Bgjh.c.get(paramString);
        if ((localbfif != null) && (localbfif.d))
        {
          localbfif.h += 1;
          localbfif.b((int)NetConnInfoCenter.getServerTime());
          j = this.jdField_a_of_type_JavaUtilList.size();
          i = 0;
          if (i < j)
          {
            if (localbfif != this.jdField_a_of_type_JavaUtilList.get(i)) {
              break;
            }
            localbgjn.jdField_a_of_type_JavaUtilList.remove(i);
          }
          localbgjn.jdField_a_of_type_JavaUtilList.add(0, localbfif);
          localbgjn.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
          a(localbgjn.jdField_a_of_type_JavaUtilList, localbgjn.jdField_a_of_type_Boolean, 0, false);
        }
      } while (!this.jdField_b_of_type_JavaLangString.equals(paramString));
      paramString = (bgjn)this.jdField_a_of_type_Bgjh.d.get(paramString + this.jdField_a_of_type_Long);
    } while ((paramString == null) || (paramString.jdField_a_of_type_JavaUtilList == null));
    boolean bool = paramString.jdField_a_of_type_Boolean;
    int j = this.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        if ((!((bfif)this.jdField_a_of_type_JavaUtilList.get(i)).d) && (parambfif.a() >= ((bfif)this.jdField_a_of_type_JavaUtilList.get(i)).a()))
        {
          paramString.jdField_a_of_type_JavaUtilList.add(i, parambfif);
          paramString.jdField_a_of_type_JavaUtilMap.put(parambfif.jdField_b_of_type_JavaLangString, parambfif);
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
        paramString.jdField_a_of_type_JavaUtilList.add(parambfif);
        paramString.jdField_a_of_type_JavaUtilMap.put(parambfif.jdField_b_of_type_JavaLangString, parambfif);
        a(paramString.jdField_a_of_type_JavaUtilList, paramString.jdField_a_of_type_Boolean, 0, false);
      }
      i += 1;
    }
  }
  
  public void a(bfmh parambfmh)
  {
    this.jdField_a_of_type_Bfmh = parambfmh;
  }
  
  public void a(bfmn parambfmn)
  {
    this.jdField_a_of_type_Bfmn = parambfmn;
  }
  
  public void a(List<bfif> paramList, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
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
    } while ((!paramBoolean1) || (!this.jdField_a_of_type_Bgjh.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Long)) || (this.jdField_a_of_type_Bfmh == null));
    this.jdField_a_of_type_Bfmh.d(7);
  }
  
  public void a(List<bfif> paramList, boolean paramBoolean, String paramString, long paramLong)
  {
    if ((!this.jdField_b_of_type_JavaLangString.equals(paramString)) || (this.jdField_a_of_type_Long != paramLong)) {}
    do
    {
      return;
      if (paramList != null) {
        break;
      }
      if (this.jdField_a_of_type_Bfmh != null) {
        this.jdField_a_of_type_Bfmh.d(3);
      }
      audr.a(2131697294);
    } while (!this.jdField_a_of_type_JavaUtilList.isEmpty());
    b(1);
    return;
    if (this.jdField_a_of_type_Bfmh != null) {
      this.jdField_a_of_type_Bfmh.d(4);
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
  
  public void a(boolean paramBoolean, bfif parambfif)
  {
    if (this.jdField_b_of_type_JavaUtilList == null) {
      return;
    }
    if (parambfif == null) {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "onSelected. fileInfo is null.");
    }
    if (paramBoolean) {
      if (!this.jdField_b_of_type_JavaUtilList.contains(parambfif)) {
        this.jdField_b_of_type_JavaUtilList.add(parambfif);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Bfmn != null) {
        this.jdField_a_of_type_Bfmn.a(paramBoolean, parambfif);
      }
      notifyDataSetChanged();
      return;
      this.jdField_b_of_type_JavaUtilList.remove(parambfif);
    }
  }
  
  public boolean a(bfif parambfif)
  {
    if ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.isEmpty())) {
      return false;
    }
    return this.jdField_b_of_type_JavaUtilList.contains(parambfif);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bgjh != null) {
      this.jdField_a_of_type_Bgjh.unregisterObserver(this);
    }
    if (this.jdField_b_of_type_JavaUtilList != null) {
      this.jdField_b_of_type_JavaUtilList.clear();
    }
  }
  
  protected void b(int paramInt)
  {
    if (this.jdField_a_of_type_Bfmh != null) {
      this.jdField_a_of_type_Bfmh.c(paramInt);
    }
  }
  
  public void b(bfif parambfif)
  {
    if (parambfif == null) {}
    label146:
    do
    {
      do
      {
        do
        {
          bfmi localbfmi;
          do
          {
            return;
            switch (parambfif.e)
            {
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            default: 
              if ((!this.jdField_b_of_type_JavaLangString.equals(parambfif.g)) && (this.jdField_a_of_type_Long == 0L)) {
                break label146;
              }
              localbfmi = (bfmi)this.jdField_a_of_type_JavaUtilMap.get(parambfif.a);
            }
          } while ((localbfmi == null) || (!localbfmi.a.a.equals(parambfif.a)));
          localbfmi.a = parambfif;
          localbfmi.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Boolean);
          parambfif = (bfif)this.jdField_a_of_type_Bgjh.c.get(parambfif.g);
        } while (parambfif == null);
        parambfif = (bfmi)this.jdField_a_of_type_JavaUtilMap.get(parambfif.a);
      } while (parambfif == null);
      parambfif.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Boolean);
      return;
    } while (this.jdField_a_of_type_JavaUtilMap.remove(parambfif.a) == null);
    this.jdField_c_of_type_Boolean = false;
    notifyDataSetChanged();
  }
  
  public void c(bfif parambfif) {}
  
  public void d(bfif parambfif)
  {
    Object localObject;
    bgjn localbgjn;
    if ((parambfif.jdField_c_of_type_Boolean) && (parambfif.e == 6))
    {
      localObject = (bfif)this.jdField_a_of_type_Bgjh.c.get(parambfif.g);
      if ((localObject == null) || (!this.jdField_b_of_type_JavaLangString.equals(((bfif)localObject).g)) || (!((bfif)localObject).d)) {
        break label251;
      }
      localbgjn = (bgjn)this.jdField_a_of_type_Bgjh.d.get(((bfif)localObject).g + this.jdField_a_of_type_Long);
      if ((localbgjn != null) && (localbgjn.jdField_a_of_type_JavaUtilList != null)) {
        break label121;
      }
    }
    label121:
    label251:
    do
    {
      return;
      if (TextUtils.isEmpty(parambfif.c()))
      {
        if (parambfif.jdField_b_of_type_Long != 0L) {
          break;
        }
        parambfif.f = ContactUtils.getDisplayName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_b_of_type_Long + "", 1, 0);
      }
      localbgjn.jdField_a_of_type_JavaUtilList.remove(localObject);
      ((bfif)localObject).b(parambfif.a());
      ((bfif)localObject).h += 1;
      localbgjn.jdField_a_of_type_JavaUtilList.add(0, localObject);
      a(localbgjn.jdField_a_of_type_JavaUtilList, localbgjn.jdField_a_of_type_Boolean, 0, false);
      localbgjn.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
      if (!this.jdField_b_of_type_JavaLangString.equals(parambfif.g)) {
        break label618;
      }
      localObject = (bgjn)this.jdField_a_of_type_Bgjh.d.get(parambfif.g + this.jdField_a_of_type_Long);
    } while ((localObject == null) || (((bgjn)localObject).jdField_a_of_type_JavaUtilList == null));
    boolean bool = ((bgjn)localObject).jdField_a_of_type_Boolean;
    int j = this.jdField_a_of_type_JavaUtilList.size();
    label397:
    int i;
    if (TextUtils.isEmpty(parambfif.c()))
    {
      if (parambfif.jdField_b_of_type_Long == 0L) {
        parambfif.f = ContactUtils.getDisplayName(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_b_of_type_Long + "", 1, 0);
      }
    }
    else
    {
      if (this.jdField_a_of_type_JavaUtilList.size() == 0)
      {
        ((bgjn)localObject).jdField_a_of_type_JavaUtilList.add(parambfif);
        ((bgjn)localObject).jdField_a_of_type_JavaUtilMap.put(parambfif.jdField_b_of_type_JavaLangString, parambfif);
      }
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        if ((!((bfif)this.jdField_a_of_type_JavaUtilList.get(i)).d) && (parambfif.a() >= ((bfif)this.jdField_a_of_type_JavaUtilList.get(i)).a()))
        {
          ((bgjn)localObject).jdField_a_of_type_JavaUtilList.add(i, parambfif);
          ((bgjn)localObject).jdField_a_of_type_JavaUtilMap.put(parambfif.jdField_b_of_type_JavaLangString, parambfif);
          notifyDataSetChanged();
        }
      }
      else
      {
        ((bgjn)localObject).jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
        a(((bgjn)localObject).jdField_a_of_type_JavaUtilList, ((bgjn)localObject).jdField_a_of_type_Boolean, 0, false);
        return;
        parambfif.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
        break;
        parambfif.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
        break label397;
      }
      if ((i == j - 1) && (bool))
      {
        ((bgjn)localObject).jdField_a_of_type_JavaUtilList.add(parambfif);
        ((bgjn)localObject).jdField_a_of_type_JavaUtilMap.put(parambfif.jdField_b_of_type_JavaLangString, parambfif);
      }
      i += 1;
    }
    label618:
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void e(bfif parambfif)
  {
    if ((parambfif.d) && ("/".equals(this.jdField_b_of_type_JavaLangString)) && (this.jdField_a_of_type_Long == 0L))
    {
      parambfif.a = UUID.randomUUID();
      this.jdField_a_of_type_Bgjh.b.put(parambfif.a, parambfif);
      this.jdField_a_of_type_Bgjh.c.put(parambfif.jdField_b_of_type_JavaLangString, parambfif);
      bgjn localbgjn = (bgjn)this.jdField_a_of_type_Bgjh.d.get(this.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_Long);
      if (localbgjn != null)
      {
        if ((localbgjn.jdField_a_of_type_JavaUtilList != null) && (localbgjn.jdField_a_of_type_JavaUtilMap != null))
        {
          localbgjn.jdField_a_of_type_JavaUtilList.add(0, parambfif);
          localbgjn.jdField_a_of_type_JavaUtilMap.put(parambfif.jdField_b_of_type_JavaLangString, parambfif);
        }
        this.jdField_a_of_type_Bgjh.c.put(parambfif.jdField_b_of_type_JavaLangString, parambfif);
        a(localbgjn.jdField_a_of_type_JavaUtilList, localbgjn.jdField_a_of_type_Boolean, 0, false);
        localbgjn.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
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
    bfif localbfif = (bfif)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (paramView == null)
    {
      bfmi localbfmi = new bfmi(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_Long, 2131560864, this.jdField_c_of_type_Int);
      localbfmi.a(this);
      paramView = localbfmi.b;
      if (paramView == null)
      {
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return localObject;
      }
      paramView.setTag(localbfmi);
      localObject = localbfmi;
    }
    for (;;)
    {
      label157:
      this.jdField_a_of_type_JavaUtilMap.put(localbfif.a, localObject);
      if (localObject != null)
      {
        ((bfmi)localObject).a = localbfif;
        ((bfmi)localObject).a(this.d);
        ((bfmi)localObject).a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if ((!this.d) || (!a(localbfif))) {
          break label285;
        }
      }
      label285:
      for (boolean bool = true;; bool = false)
      {
        ((bfmi)localObject).b(bool);
        ((bfmi)localObject).a(this.jdField_b_of_type_Long, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Boolean);
        localObject = paramView;
        break;
        localObject = paramView.getTag();
        if (!(localObject instanceof bfmi)) {
          break label291;
        }
        localObject = (bfmi)localObject;
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
      if ((this.jdField_a_of_type_Int == this.jdField_b_of_type_Int - 2) && (this.jdField_a_of_type_Bgjh != null))
      {
        if (!this.jdField_a_of_type_Bgjh.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Long)) {
          break label88;
        }
        if (this.jdField_a_of_type_Bfmh != null) {
          this.jdField_a_of_type_Bfmh.d(8);
        }
      }
      label88:
      do
      {
        return;
        this.jdField_a_of_type_Bfmh.d(7);
      } while (bgke.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_Long) == 0);
      this.jdField_a_of_type_Bgjh.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Long);
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfms
 * JD-Core Version:    0.7.0.1
 */