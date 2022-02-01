import android.text.TextUtils;
import com.tencent.mobileqq.together.writetogether.data.EditUserHistory;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class beot
  implements beow
{
  private int jdField_a_of_type_Int = 10000;
  private long jdField_a_of_type_Long;
  private belh jdField_a_of_type_Belh;
  private beli jdField_a_of_type_Beli;
  private beob jdField_a_of_type_Beob;
  private beod jdField_a_of_type_Beod;
  private beok jdField_a_of_type_Beok;
  private beop jdField_a_of_type_Beop;
  private beor jdField_a_of_type_Beor;
  private String jdField_a_of_type_JavaLangString = "";
  private List<String> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map<String, Long> jdField_a_of_type_JavaUtilMap = new TreeMap();
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString = "";
  private List<String> jdField_b_of_type_JavaUtilList = new ArrayList();
  private Map<String, String> jdField_b_of_type_JavaUtilMap = new TreeMap();
  private String c = "";
  private String d = "";
  private String e;
  
  public beot(belh parambelh, beli parambeli, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Belh = parambelh;
    this.jdField_a_of_type_Beli = parambeli;
    this.jdField_b_of_type_JavaLangString = paramString1;
  }
  
  private void a(String paramString1, String paramString2)
  {
    int i = 0;
    if (this.jdField_b_of_type_JavaLangString.equals(paramString1)) {
      i = 1;
    }
    if (i == 0)
    {
      this.jdField_a_of_type_JavaUtilList.remove(paramString1);
      this.jdField_a_of_type_JavaUtilList.add(paramString1);
      this.jdField_b_of_type_JavaUtilList.remove(paramString1);
      this.jdField_b_of_type_JavaUtilList.add(paramString1);
      long l = b();
      this.jdField_a_of_type_JavaUtilMap.put(paramString1, Long.valueOf(l));
      b(this.jdField_a_of_type_JavaUtilList);
      b(this.jdField_b_of_type_JavaUtilList);
      if (this.jdField_a_of_type_Beod != null) {
        this.jdField_a_of_type_Beod.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilList, true);
      }
    }
    this.e = paramString1;
    this.jdField_a_of_type_Long = b();
    if (this.jdField_a_of_type_Beok != null)
    {
      if (i == 0) {
        this.jdField_a_of_type_Beok.b();
      }
      this.jdField_a_of_type_Beok.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Belh.jdField_a_of_type_JavaLangString.length());
    }
    if (i == 0) {
      this.jdField_a_of_type_Beop.b(paramString2);
    }
    this.jdField_a_of_type_Beop.a(paramString1, paramString2);
  }
  
  private long b()
  {
    return System.currentTimeMillis();
  }
  
  private void b()
  {
    boolean bool;
    label30:
    beod localbeod;
    String str;
    if (this.jdField_a_of_type_Beod != null)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
        break label66;
      }
      bool = true;
      if (!bool) {
        break label71;
      }
      localList = this.jdField_a_of_type_JavaUtilList;
      b(localList);
      localbeod = this.jdField_a_of_type_Beod;
      str = this.jdField_a_of_type_JavaLangString;
      if (!bool) {
        break label79;
      }
    }
    label66:
    label71:
    label79:
    for (List localList = this.jdField_a_of_type_JavaUtilList;; localList = this.jdField_b_of_type_JavaUtilList)
    {
      localbeod.a(str, localList, bool);
      return;
      bool = false;
      break;
      localList = this.jdField_b_of_type_JavaUtilList;
      break label30;
    }
  }
  
  private void b(List<String> paramList)
  {
    Collections.sort(paramList, new beou(this));
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public belh a()
  {
    return this.jdField_a_of_type_Belh;
  }
  
  public beli a()
  {
    return this.jdField_a_of_type_Beli;
  }
  
  public beoo a()
  {
    beoo localbeoo = new beoo();
    localbeoo.d = this.jdField_a_of_type_Belh.jdField_a_of_type_JavaLangString;
    localbeoo.e = this.jdField_a_of_type_Belh.jdField_b_of_type_JavaLangString;
    localbeoo.c = this.jdField_a_of_type_Beli.a();
    return localbeoo;
  }
  
  public beor a()
  {
    return this.jdField_a_of_type_Beor;
  }
  
  public Pair<Integer, Integer> a()
  {
    return this.jdField_a_of_type_Beop.a();
  }
  
  public String a()
  {
    return this.e;
  }
  
  public String a(String paramString)
  {
    if (this.jdField_b_of_type_JavaUtilMap != null) {
      return (String)this.jdField_b_of_type_JavaUtilMap.get(paramString);
    }
    return null;
  }
  
  public List<bepb> a()
  {
    return this.jdField_a_of_type_Beop.a();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Beod != null) {
      this.jdField_a_of_type_Beod.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaUtilList, false);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Beop != null) {
      this.jdField_a_of_type_Beop.a(paramInt1, paramInt2, false);
    }
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(belh parambelh)
  {
    belh localbelh = parambelh;
    if (parambelh == null) {
      localbelh = new belh("", "");
    }
    this.jdField_a_of_type_Belh = localbelh;
  }
  
  public void a(beli parambeli)
  {
    beli localbeli = parambeli;
    if (parambeli == null) {
      localbeli = new beli();
    }
    this.jdField_a_of_type_Beli = localbeli;
  }
  
  public void a(beob parambeob)
  {
    this.jdField_a_of_type_Beob = parambeob;
  }
  
  public void a(beod parambeod)
  {
    this.jdField_a_of_type_Beod = parambeod;
  }
  
  public void a(beok parambeok)
  {
    this.jdField_a_of_type_Beok = parambeok;
  }
  
  public void a(beop parambeop)
  {
    this.jdField_a_of_type_Beop = parambeop;
  }
  
  public void a(beor parambeor)
  {
    this.jdField_a_of_type_Beor = parambeor;
    this.jdField_a_of_type_JavaLangString = parambeor.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Long = parambeor.jdField_a_of_type_Long;
    if ((this.jdField_a_of_type_Long <= 0L) && (QLog.isColorLevel())) {
      QLog.e("EditorModel", 2, "metaData.mTime lt 0");
    }
    if (this.jdField_a_of_type_Beok != null) {
      this.jdField_a_of_type_Beok.b();
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramString);
    b();
    this.jdField_a_of_type_Beop.a(paramString);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      this.jdField_a_of_type_Beop.a(paramString, paramInt1, paramInt2);
    } while (paramString.equals(this.jdField_b_of_type_JavaLangString));
    this.jdField_a_of_type_JavaUtilList.remove(paramString);
    this.jdField_a_of_type_JavaUtilList.add(paramString);
    long l = b();
    this.jdField_a_of_type_JavaUtilMap.put(paramString, Long.valueOf(l));
    b();
  }
  
  public void a(String paramString, long paramLong, bepb parambepb)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramLong <= 0L)) {
      QLog.e("EditorModel", 1, "[addParticipant error] author: " + paramString + ", aliveTimeSec: " + paramLong);
    }
    do
    {
      return;
      b();
    } while (parambepb.jdField_a_of_type_JavaLangString.equals(this.jdField_b_of_type_JavaLangString));
    this.jdField_a_of_type_Beop.a(paramString, parambepb);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    this.d = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.c = paramString3;
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditorModel", 2, "[new changeset] - notifyView: " + paramBoolean + ", cs: " + paramString1);
    }
    this.jdField_a_of_type_Belh = belm.a(paramString1, this.jdField_a_of_type_Belh, this.jdField_a_of_type_Beli);
    if (paramBoolean) {
      this.jdField_a_of_type_Beob.a(this.jdField_a_of_type_Belh.jdField_a_of_type_JavaLangString);
    }
    a(paramString2, paramString1);
  }
  
  public void a(List<EditUserHistory> paramList)
  {
    if (paramList == null) {
      if (QLog.isColorLevel()) {
        QLog.d("EditorModel", 2, "histories is null");
      }
    }
    do
    {
      do
      {
        return;
        if ((paramList.size() == 0) && (QLog.isColorLevel())) {
          QLog.d("EditorModel", 2, "histories size is 0");
        }
        this.jdField_b_of_type_JavaUtilList = new ArrayList();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          EditUserHistory localEditUserHistory = (EditUserHistory)paramList.next();
          if (localEditUserHistory != null)
          {
            String str = localEditUserHistory.jdField_a_of_type_JavaLangString;
            long l = localEditUserHistory.jdField_a_of_type_Long * 1000L;
            if (QLog.isColorLevel()) {
              QLog.d("EditorModel", 2, "[setEditUserHistory] uin: " + str + ", editTime: " + l);
            }
            this.jdField_b_of_type_JavaUtilList.add(str);
            this.jdField_a_of_type_JavaUtilMap.put(str, Long.valueOf(l));
            if (this.jdField_b_of_type_JavaUtilMap != null) {
              this.jdField_b_of_type_JavaUtilMap.put(str, localEditUserHistory.jdField_b_of_type_JavaLangString);
            }
          }
        }
        b(this.jdField_b_of_type_JavaUtilList);
      } while (this.jdField_b_of_type_JavaUtilList.size() == 0);
      this.e = ((String)this.jdField_b_of_type_JavaUtilList.get(0));
      paramList = (Long)this.jdField_a_of_type_JavaUtilMap.get(this.e);
    } while (paramList == null);
    this.jdField_a_of_type_Long = paramList.longValue();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Beop.a(paramBoolean);
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void b(String paramString)
  {
    this.e = paramString;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public String d()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beot
 * JD-Core Version:    0.7.0.1
 */