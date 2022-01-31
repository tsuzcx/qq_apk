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

public class aztg
  extends BaseAdapter
  implements Handler.Callback, azqk, aztb, bfos
{
  public static String a;
  public int a;
  public long a;
  private Context jdField_a_of_type_AndroidContentContext;
  public Handler a;
  private azsv jdField_a_of_type_Azsv;
  private bajy jdField_a_of_type_Bajy;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private TroopFileTransferManager jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager;
  private List<azpi> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map<UUID, azsw> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  public int b;
  private long jdField_b_of_type_Long;
  public String b;
  private List<azpi> jdField_b_of_type_JavaUtilList = new ArrayList(20);
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  
  static
  {
    jdField_a_of_type_JavaLangString = "TroopFileExpandableListAdapter<QFile>";
  }
  
  public aztg(QQAppInterface paramQQAppInterface, Context paramContext, long paramLong, String paramString, int paramInt)
  {
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_b_of_type_Long = paramLong;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
    this.jdField_a_of_type_Bajy = bajy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
    this.jdField_a_of_type_Bajy.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    if (!this.jdField_a_of_type_Bajy.a(this)) {
      this.jdField_a_of_type_Bajy.registerObserver(this);
    }
  }
  
  private List<azpi> a(List<azpi> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return paramList;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      azpi localazpi = (azpi)paramList.next();
      if ((TextUtils.isEmpty(localazpi.jdField_b_of_type_JavaLangString)) || (!localazpi.jdField_b_of_type_JavaLangString.contains("online_doc_folder_"))) {
        localArrayList.add(localazpi);
      }
    }
    return localArrayList;
  }
  
  public List<azpi> a()
  {
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  public void a()
  {
    int i;
    int j;
    if (this.jdField_a_of_type_Azsv != null)
    {
      i = this.jdField_a_of_type_Azsv.d();
      j = this.jdField_a_of_type_Azsv.e();
    }
    for (;;)
    {
      if ((i > j - 1) || (i >= this.jdField_a_of_type_JavaUtilList.size())) {
        return;
      }
      Object localObject = (azpi)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localObject == null) {}
      for (;;)
      {
        i += 1;
        break;
        localObject = (azsw)this.jdField_a_of_type_JavaUtilMap.get(((azpi)localObject).a);
        if (localObject != null)
        {
          ((azsw)localObject).b(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          ((azsw)localObject).a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
    boolean bool = bbfj.g(this.jdField_a_of_type_AndroidContentContext);
    if ((bool) && (this.jdField_a_of_type_Bajy.a(paramInt1, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Long)))
    {
      paramInt1 = 1;
      localObject = (bake)this.jdField_a_of_type_Bajy.d.get(this.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_Long);
      if (localObject == null) {
        break label169;
      }
    }
    label169:
    for (Object localObject = ((bake)localObject).jdField_a_of_type_JavaUtilList;; localObject = null)
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
      bakx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
      return;
    }
  }
  
  public void a(azpi paramazpi)
  {
    if ((paramazpi.jdField_e_of_type_Int == 2) || (paramazpi.jdField_e_of_type_Int == 3)) {
      return;
    }
    int j = this.jdField_a_of_type_JavaUtilList.size();
    azpi localazpi = (azpi)this.jdField_a_of_type_Bajy.c.get(paramazpi.f);
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        if ((this.jdField_a_of_type_JavaUtilList.get(i) == null) || (!((azpi)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_b_of_type_JavaLangString.equals(paramazpi.jdField_b_of_type_JavaLangString))) {
          break label451;
        }
        bake localbake = (bake)this.jdField_a_of_type_Bajy.d.get(this.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_Long);
        if (localbake == null) {
          break label451;
        }
        if ((localbake.jdField_a_of_type_JavaUtilList != null) && (localbake.jdField_a_of_type_JavaUtilMap != null))
        {
          localbake.jdField_a_of_type_JavaUtilMap.remove(((azpi)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_b_of_type_JavaLangString);
          if (i >= localbake.jdField_a_of_type_JavaUtilList.size()) {
            break label421;
          }
          paramazpi = (azpi)localbake.jdField_a_of_type_JavaUtilList.remove(i);
          if ((paramazpi != null) && (paramazpi.jdField_e_of_type_Int != 12) && (localazpi != null)) {
            localazpi.h -= 1;
          }
          if ((paramazpi != null) && (paramazpi.jdField_e_of_type_Int != 12)) {
            localbake.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
          }
          this.jdField_c_of_type_Boolean = false;
          a(localbake.jdField_a_of_type_JavaUtilList, localbake.jdField_a_of_type_Boolean, 0, false);
        }
      }
      for (;;)
      {
        if ((localazpi == null) || (!"/".equals(this.jdField_b_of_type_JavaLangString)) || (this.jdField_a_of_type_Long != 0L) || (!localazpi.d)) {
          break label449;
        }
        localazpi.b((int)NetConnInfoCenter.getServerTime());
        paramazpi = (bake)this.jdField_a_of_type_Bajy.d.get(localazpi.f + this.jdField_a_of_type_Long);
        if (paramazpi == null) {
          break;
        }
        if (paramazpi.jdField_a_of_type_JavaUtilList != null)
        {
          paramazpi.jdField_a_of_type_JavaUtilList.remove(localazpi);
          paramazpi.jdField_a_of_type_JavaUtilList.add(0, localazpi);
        }
        paramazpi.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
        a(paramazpi.jdField_a_of_type_JavaUtilList, paramazpi.jdField_a_of_type_Boolean, 0, false);
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
  
  public void a(azpi paramazpi, String paramString)
  {
    if (paramazpi == null) {}
    do
    {
      do
      {
        bake localbake;
        do
        {
          return;
          if (!this.jdField_b_of_type_JavaLangString.equals("/")) {
            break;
          }
          localbake = (bake)this.jdField_a_of_type_Bajy.d.get("/" + this.jdField_a_of_type_Long);
        } while ((localbake == null) || (localbake.jdField_a_of_type_JavaUtilList == null));
        azpi localazpi = (azpi)this.jdField_a_of_type_Bajy.c.get(paramString);
        if ((localazpi != null) && (localazpi.d))
        {
          localazpi.h += 1;
          localazpi.b((int)NetConnInfoCenter.getServerTime());
          j = this.jdField_a_of_type_JavaUtilList.size();
          i = 0;
          if (i < j)
          {
            if (localazpi != this.jdField_a_of_type_JavaUtilList.get(i)) {
              break;
            }
            localbake.jdField_a_of_type_JavaUtilList.remove(i);
          }
          localbake.jdField_a_of_type_JavaUtilList.add(0, localazpi);
          localbake.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
          a(localbake.jdField_a_of_type_JavaUtilList, localbake.jdField_a_of_type_Boolean, 0, false);
        }
      } while (!this.jdField_b_of_type_JavaLangString.equals(paramString));
      paramString = (bake)this.jdField_a_of_type_Bajy.d.get(paramString + this.jdField_a_of_type_Long);
    } while ((paramString == null) || (paramString.jdField_a_of_type_JavaUtilList == null));
    boolean bool = paramString.jdField_a_of_type_Boolean;
    int j = this.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        if ((!((azpi)this.jdField_a_of_type_JavaUtilList.get(i)).d) && (paramazpi.a() >= ((azpi)this.jdField_a_of_type_JavaUtilList.get(i)).a()))
        {
          paramString.jdField_a_of_type_JavaUtilList.add(i, paramazpi);
          paramString.jdField_a_of_type_JavaUtilMap.put(paramazpi.jdField_b_of_type_JavaLangString, paramazpi);
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
        paramString.jdField_a_of_type_JavaUtilList.add(paramazpi);
        paramString.jdField_a_of_type_JavaUtilMap.put(paramazpi.jdField_b_of_type_JavaLangString, paramazpi);
        a(paramString.jdField_a_of_type_JavaUtilList, paramString.jdField_a_of_type_Boolean, 0, false);
      }
      i += 1;
    }
  }
  
  public void a(azsv paramazsv)
  {
    this.jdField_a_of_type_Azsv = paramazsv;
  }
  
  public void a(List<azpi> paramList, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
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
    } while ((!paramBoolean1) || (!this.jdField_a_of_type_Bajy.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Long)) || (this.jdField_a_of_type_Azsv == null));
    this.jdField_a_of_type_Azsv.d(7);
  }
  
  public void a(List<azpi> paramList, boolean paramBoolean, String paramString, long paramLong)
  {
    if ((!this.jdField_b_of_type_JavaLangString.equals(paramString)) || (this.jdField_a_of_type_Long != paramLong)) {}
    do
    {
      return;
      if (paramList != null) {
        break;
      }
      if (this.jdField_a_of_type_Azsv != null) {
        this.jdField_a_of_type_Azsv.d(3);
      }
      aptx.a(2131697805);
    } while (!this.jdField_a_of_type_JavaUtilList.isEmpty());
    b(1);
    return;
    if (this.jdField_a_of_type_Azsv != null) {
      this.jdField_a_of_type_Azsv.d(4);
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
  
  public void a(boolean paramBoolean, azpi paramazpi)
  {
    if (this.jdField_b_of_type_JavaUtilList == null) {
      return;
    }
    if (paramazpi == null) {
      QLog.i(jdField_a_of_type_JavaLangString, 1, "onSelected. fileInfo is null.");
    }
    if (paramBoolean) {
      if (!this.jdField_b_of_type_JavaUtilList.contains(paramazpi)) {
        this.jdField_b_of_type_JavaUtilList.add(paramazpi);
      }
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      this.jdField_b_of_type_JavaUtilList.remove(paramazpi);
    }
  }
  
  public boolean a(azpi paramazpi)
  {
    if ((this.jdField_b_of_type_JavaUtilList == null) || (this.jdField_b_of_type_JavaUtilList.isEmpty())) {
      return false;
    }
    return this.jdField_b_of_type_JavaUtilList.contains(paramazpi);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bajy != null) {
      this.jdField_a_of_type_Bajy.unregisterObserver(this);
    }
    if (this.jdField_b_of_type_JavaUtilList != null) {
      this.jdField_b_of_type_JavaUtilList.clear();
    }
  }
  
  protected void b(int paramInt)
  {
    if (this.jdField_a_of_type_Azsv != null) {
      this.jdField_a_of_type_Azsv.c(paramInt);
    }
  }
  
  public void b(azpi paramazpi)
  {
    if (paramazpi == null) {}
    label146:
    do
    {
      do
      {
        do
        {
          azsw localazsw;
          do
          {
            return;
            switch (paramazpi.jdField_e_of_type_Int)
            {
            case 0: 
            case 1: 
            case 2: 
            case 3: 
            default: 
              if ((!this.jdField_b_of_type_JavaLangString.equals(paramazpi.f)) && (this.jdField_a_of_type_Long == 0L)) {
                break label146;
              }
              localazsw = (azsw)this.jdField_a_of_type_JavaUtilMap.get(paramazpi.a);
            }
          } while ((localazsw == null) || (!localazsw.a.a.equals(paramazpi.a)));
          localazsw.a = paramazpi;
          localazsw.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Boolean);
          paramazpi = (azpi)this.jdField_a_of_type_Bajy.c.get(paramazpi.f);
        } while (paramazpi == null);
        paramazpi = (azsw)this.jdField_a_of_type_JavaUtilMap.get(paramazpi.a);
      } while (paramazpi == null);
      paramazpi.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Boolean);
      return;
    } while (this.jdField_a_of_type_JavaUtilMap.remove(paramazpi.a) == null);
    this.jdField_c_of_type_Boolean = false;
    notifyDataSetChanged();
  }
  
  public void c(azpi paramazpi) {}
  
  public void d(azpi paramazpi)
  {
    Object localObject;
    bake localbake;
    if ((paramazpi.jdField_c_of_type_Boolean) && (paramazpi.jdField_e_of_type_Int == 6))
    {
      localObject = (azpi)this.jdField_a_of_type_Bajy.c.get(paramazpi.f);
      if ((localObject == null) || (!this.jdField_b_of_type_JavaLangString.equals(((azpi)localObject).f)) || (!((azpi)localObject).d)) {
        break label251;
      }
      localbake = (bake)this.jdField_a_of_type_Bajy.d.get(((azpi)localObject).f + this.jdField_a_of_type_Long);
      if ((localbake != null) && (localbake.jdField_a_of_type_JavaUtilList != null)) {
        break label121;
      }
    }
    label121:
    label251:
    do
    {
      return;
      if (TextUtils.isEmpty(paramazpi.c()))
      {
        if (paramazpi.jdField_b_of_type_Long != 0L) {
          break;
        }
        paramazpi.jdField_e_of_type_JavaLangString = bbcz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_b_of_type_Long + "", 1, 0);
      }
      localbake.jdField_a_of_type_JavaUtilList.remove(localObject);
      ((azpi)localObject).b(paramazpi.a());
      ((azpi)localObject).h += 1;
      localbake.jdField_a_of_type_JavaUtilList.add(0, localObject);
      a(localbake.jdField_a_of_type_JavaUtilList, localbake.jdField_a_of_type_Boolean, 0, false);
      localbake.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
      if (!this.jdField_b_of_type_JavaLangString.equals(paramazpi.f)) {
        break label618;
      }
      localObject = (bake)this.jdField_a_of_type_Bajy.d.get(paramazpi.f + this.jdField_a_of_type_Long);
    } while ((localObject == null) || (((bake)localObject).jdField_a_of_type_JavaUtilList == null));
    boolean bool = ((bake)localObject).jdField_a_of_type_Boolean;
    int j = this.jdField_a_of_type_JavaUtilList.size();
    label397:
    int i;
    if (TextUtils.isEmpty(paramazpi.c()))
    {
      if (paramazpi.jdField_b_of_type_Long == 0L) {
        paramazpi.jdField_e_of_type_JavaLangString = bbcz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_b_of_type_Long + "", 1, 0);
      }
    }
    else
    {
      if (this.jdField_a_of_type_JavaUtilList.size() == 0)
      {
        ((bake)localObject).jdField_a_of_type_JavaUtilList.add(paramazpi);
        ((bake)localObject).jdField_a_of_type_JavaUtilMap.put(paramazpi.jdField_b_of_type_JavaLangString, paramazpi);
      }
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        if ((!((azpi)this.jdField_a_of_type_JavaUtilList.get(i)).d) && (paramazpi.a() >= ((azpi)this.jdField_a_of_type_JavaUtilList.get(i)).a()))
        {
          ((bake)localObject).jdField_a_of_type_JavaUtilList.add(i, paramazpi);
          ((bake)localObject).jdField_a_of_type_JavaUtilMap.put(paramazpi.jdField_b_of_type_JavaLangString, paramazpi);
          notifyDataSetChanged();
        }
      }
      else
      {
        ((bake)localObject).jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
        a(((bake)localObject).jdField_a_of_type_JavaUtilList, ((bake)localObject).jdField_a_of_type_Boolean, 0, false);
        return;
        paramazpi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
        break;
        paramazpi.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Long);
        break label397;
      }
      if ((i == j - 1) && (bool))
      {
        ((bake)localObject).jdField_a_of_type_JavaUtilList.add(paramazpi);
        ((bake)localObject).jdField_a_of_type_JavaUtilMap.put(paramazpi.jdField_b_of_type_JavaLangString, paramazpi);
      }
      i += 1;
    }
    label618:
    this.jdField_c_of_type_Boolean = false;
  }
  
  public void e(azpi paramazpi)
  {
    if ((paramazpi.d) && ("/".equals(this.jdField_b_of_type_JavaLangString)) && (this.jdField_a_of_type_Long == 0L))
    {
      paramazpi.a = UUID.randomUUID();
      this.jdField_a_of_type_Bajy.b.put(paramazpi.a, paramazpi);
      this.jdField_a_of_type_Bajy.c.put(paramazpi.jdField_b_of_type_JavaLangString, paramazpi);
      bake localbake = (bake)this.jdField_a_of_type_Bajy.d.get(this.jdField_b_of_type_JavaLangString + this.jdField_a_of_type_Long);
      if (localbake != null)
      {
        if ((localbake.jdField_a_of_type_JavaUtilList != null) && (localbake.jdField_a_of_type_JavaUtilMap != null))
        {
          localbake.jdField_a_of_type_JavaUtilList.add(0, paramazpi);
          localbake.jdField_a_of_type_JavaUtilMap.put(paramazpi.jdField_b_of_type_JavaLangString, paramazpi);
        }
        this.jdField_a_of_type_Bajy.c.put(paramazpi.jdField_b_of_type_JavaLangString, paramazpi);
        a(localbake.jdField_a_of_type_JavaUtilList, localbake.jdField_a_of_type_Boolean, 0, false);
        localbake.jdField_a_of_type_ComTencentMobileqqPbByteStringMicro = null;
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
    azpi localazpi = (azpi)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (paramView == null)
    {
      paramViewGroup = new azsw(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_Long, 2131560494, this.jdField_c_of_type_Int);
      paramViewGroup.a(this);
      paramView = paramViewGroup.b;
      if (paramView == null) {
        return null;
      }
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilMap.put(localazpi.a, paramViewGroup);
      if (paramViewGroup != null)
      {
        paramViewGroup.a = localazpi;
        paramViewGroup.a(this.d);
        paramViewGroup.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if ((!this.d) || (!a(localazpi))) {
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
        if (!(paramViewGroup instanceof azsw)) {
          break label250;
        }
        paramViewGroup = (azsw)paramViewGroup;
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
      if ((this.jdField_a_of_type_Int == this.jdField_b_of_type_Int - 2) && (this.jdField_a_of_type_Bajy != null))
      {
        if (!this.jdField_a_of_type_Bajy.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Long)) {
          break label88;
        }
        if (this.jdField_a_of_type_Azsv != null) {
          this.jdField_a_of_type_Azsv.d(8);
        }
      }
      label88:
      do
      {
        return;
        this.jdField_a_of_type_Azsv.d(7);
      } while (bakx.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_Long) == 0);
      this.jdField_a_of_type_Bajy.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Long);
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aztg
 * JD-Core Version:    0.7.0.1
 */