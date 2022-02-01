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

public class beny
  implements beob
{
  private int jdField_a_of_type_Int = 10000;
  private long jdField_a_of_type_Long;
  private bekn jdField_a_of_type_Bekn;
  private beko jdField_a_of_type_Beko;
  private beng jdField_a_of_type_Beng;
  private beni jdField_a_of_type_Beni;
  private benp jdField_a_of_type_Benp;
  private benu jdField_a_of_type_Benu;
  private benw jdField_a_of_type_Benw;
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
  
  public beny(bekn parambekn, beko parambeko, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Bekn = parambekn;
    this.jdField_a_of_type_Beko = parambeko;
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
      if (this.jdField_a_of_type_Beni != null) {
        this.jdField_a_of_type_Beni.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilList, true);
      }
    }
    this.e = paramString1;
    this.jdField_a_of_type_Long = b();
    if (this.jdField_a_of_type_Benp != null)
    {
      if (i == 0) {
        this.jdField_a_of_type_Benp.b();
      }
      this.jdField_a_of_type_Benp.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_Bekn.jdField_a_of_type_JavaLangString.length());
    }
    if (i == 0) {
      this.jdField_a_of_type_Benu.b(paramString2);
    }
    this.jdField_a_of_type_Benu.a(paramString1, paramString2);
  }
  
  private long b()
  {
    return System.currentTimeMillis();
  }
  
  private void b()
  {
    boolean bool;
    label30:
    beni localbeni;
    String str;
    if (this.jdField_a_of_type_Beni != null)
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
      localbeni = this.jdField_a_of_type_Beni;
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
      localbeni.a(str, localList, bool);
      return;
      bool = false;
      break;
      localList = this.jdField_b_of_type_JavaUtilList;
      break label30;
    }
  }
  
  private void b(List<String> paramList)
  {
    Collections.sort(paramList, new benz(this));
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public bekn a()
  {
    return this.jdField_a_of_type_Bekn;
  }
  
  public beko a()
  {
    return this.jdField_a_of_type_Beko;
  }
  
  public bent a()
  {
    bent localbent = new bent();
    localbent.d = this.jdField_a_of_type_Bekn.jdField_a_of_type_JavaLangString;
    localbent.e = this.jdField_a_of_type_Bekn.jdField_b_of_type_JavaLangString;
    localbent.c = this.jdField_a_of_type_Beko.a();
    return localbent;
  }
  
  public benw a()
  {
    return this.jdField_a_of_type_Benw;
  }
  
  public Pair<Integer, Integer> a()
  {
    return this.jdField_a_of_type_Benu.a();
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
  
  public List<beog> a()
  {
    return this.jdField_a_of_type_Benu.a();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Beni != null) {
      this.jdField_a_of_type_Beni.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaUtilList, false);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Benu != null) {
      this.jdField_a_of_type_Benu.a(paramInt1, paramInt2, false);
    }
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(bekn parambekn)
  {
    bekn localbekn = parambekn;
    if (parambekn == null) {
      localbekn = new bekn("", "");
    }
    this.jdField_a_of_type_Bekn = localbekn;
  }
  
  public void a(beko parambeko)
  {
    beko localbeko = parambeko;
    if (parambeko == null) {
      localbeko = new beko();
    }
    this.jdField_a_of_type_Beko = localbeko;
  }
  
  public void a(beng parambeng)
  {
    this.jdField_a_of_type_Beng = parambeng;
  }
  
  public void a(beni parambeni)
  {
    this.jdField_a_of_type_Beni = parambeni;
  }
  
  public void a(benp parambenp)
  {
    this.jdField_a_of_type_Benp = parambenp;
  }
  
  public void a(benu parambenu)
  {
    this.jdField_a_of_type_Benu = parambenu;
  }
  
  public void a(benw parambenw)
  {
    this.jdField_a_of_type_Benw = parambenw;
    this.jdField_a_of_type_JavaLangString = parambenw.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_Long = parambenw.jdField_a_of_type_Long;
    if ((this.jdField_a_of_type_Long <= 0L) && (QLog.isColorLevel())) {
      QLog.e("EditorModel", 2, "metaData.mTime lt 0");
    }
    if (this.jdField_a_of_type_Benp != null) {
      this.jdField_a_of_type_Benp.b();
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramString);
    b();
    this.jdField_a_of_type_Benu.a(paramString);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      this.jdField_a_of_type_Benu.a(paramString, paramInt1, paramInt2);
    } while (paramString.equals(this.jdField_b_of_type_JavaLangString));
    this.jdField_a_of_type_JavaUtilList.remove(paramString);
    this.jdField_a_of_type_JavaUtilList.add(paramString);
    long l = b();
    this.jdField_a_of_type_JavaUtilMap.put(paramString, Long.valueOf(l));
    b();
  }
  
  public void a(String paramString, long paramLong, beog parambeog)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramLong <= 0L)) {
      QLog.e("EditorModel", 1, "[addParticipant error] author: " + paramString + ", aliveTimeSec: " + paramLong);
    }
    do
    {
      return;
      b();
    } while (parambeog.jdField_a_of_type_JavaLangString.equals(this.jdField_b_of_type_JavaLangString));
    this.jdField_a_of_type_Benu.a(paramString, parambeog);
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
    this.jdField_a_of_type_Bekn = beks.a(paramString1, this.jdField_a_of_type_Bekn, this.jdField_a_of_type_Beko);
    if (paramBoolean) {
      this.jdField_a_of_type_Beng.a(this.jdField_a_of_type_Bekn.jdField_a_of_type_JavaLangString);
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
    this.jdField_a_of_type_Benu.a(paramBoolean);
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
 * Qualified Name:     beny
 * JD-Core Version:    0.7.0.1
 */