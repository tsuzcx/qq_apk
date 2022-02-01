import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.together.writetogether.data.CursorManager.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class beop
{
  private beoq jdField_a_of_type_Beoq;
  private bepb jdField_a_of_type_Bepb;
  private List<bepb> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  public beop(bepb parambepb, List<bepb> paramList)
  {
    this.jdField_a_of_type_Bepb = parambepb;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  @NotNull
  private List<bepb> a(int paramInt, List<bepb> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramList.size())
    {
      bepb localbepb = (bepb)paramList.get(i);
      if (localbepb != null)
      {
        if (paramInt != localbepb.jdField_c_of_type_Int) {
          break label70;
        }
        localbepb.jdField_a_of_type_Boolean = true;
        localArrayList.add(localbepb);
      }
      for (;;)
      {
        i += 1;
        break;
        label70:
        if (localbepb.jdField_c_of_type_Boolean) {
          localbepb.jdField_a_of_type_Boolean = false;
        }
      }
    }
    return localArrayList;
  }
  
  private void a(bepb parambepb)
  {
    if (!parambepb.jdField_c_of_type_Boolean)
    {
      parambepb.jdField_a_of_type_Boolean = true;
      ThreadManagerV2.getUIHandlerV2().postDelayed(new CursorManager.1(this, parambepb), 2000L);
    }
  }
  
  private void a(List<bepb> paramList)
  {
    if (QLog.isColorLevel())
    {
      int i = 0;
      while (i < paramList.size())
      {
        QLog.d("CursorManager", 2, "[updateMyEditInfo] info: " + ((bepb)paramList.get(i)).toString());
        i += 1;
      }
    }
  }
  
  private void a(List<bepb> paramList1, List<bepb> paramList2, int paramInt)
  {
    String str = "等" + paramInt + "人";
    int i = 0;
    bepb localbepb;
    while (i < paramInt)
    {
      localbepb = (bepb)paramList2.get(i);
      if (localbepb != null) {
        localbepb.jdField_a_of_type_Boolean = false;
      }
      i += 1;
    }
    paramList2 = (bepb)paramList2.get(paramInt - 1);
    if (paramList2 != null)
    {
      localbepb = new bepb(paramList2);
      localbepb.jdField_b_of_type_Boolean = true;
      localbepb.jdField_a_of_type_Boolean = true;
      paramList2.jdField_b_of_type_JavaLangString += str;
      paramList1.add(localbepb);
    }
  }
  
  private void b(bepb parambepb)
  {
    int i = this.jdField_a_of_type_JavaUtilList.indexOf(parambepb);
    if (i != -1) {
      Collections.swap(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilList.size() - 1, i);
    }
  }
  
  private void b(List<bepb> paramList)
  {
    if (paramList == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      bepb localbepb = (bepb)paramList.get(i);
      if ((localbepb != null) && (localbepb.jdField_b_of_type_Boolean)) {
        localArrayList.add(localbepb);
      }
      i += 1;
    }
    paramList.removeAll(localArrayList);
  }
  
  public bepb a()
  {
    return this.jdField_a_of_type_Bepb;
  }
  
  protected bepb a(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString))
    {
      localObject = new bepb();
      return localObject;
    }
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilList);
    int i = 0;
    label32:
    if (i < localArrayList.size())
    {
      localObject = (bepb)localArrayList.get(i);
      if ((localObject == null) || (!paramString.equals(((bepb)localObject).jdField_a_of_type_JavaLangString))) {}
    }
    for (paramString = (String)localObject;; paramString = null)
    {
      localObject = paramString;
      if (paramString != null) {
        break;
      }
      return new bepb();
      i += 1;
      break label32;
    }
  }
  
  public Pair<Integer, Integer> a()
  {
    return new Pair(Integer.valueOf(this.jdField_a_of_type_Bepb.jdField_c_of_type_Int), Integer.valueOf(this.jdField_a_of_type_Bepb.d));
  }
  
  public List<bepb> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Bepb.jdField_c_of_type_Int = paramInt1;
    this.jdField_a_of_type_Bepb.d = paramInt2;
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    a(paramInt1, paramInt2);
    List localList1 = a();
    b(localList1);
    List localList2 = a(paramInt1, localList1);
    a(localList1);
    int i = localList2.size();
    if (i > 1) {
      a(localList1, localList2, i);
    }
    a(localList1);
    if (this.jdField_a_of_type_Beoq != null)
    {
      this.jdField_a_of_type_Beoq.c();
      if (paramBoolean) {
        this.jdField_a_of_type_Beoq.a(paramInt1, paramInt2);
      }
    }
  }
  
  public void a(beoq parambeoq)
  {
    this.jdField_a_of_type_Beoq = parambeoq;
  }
  
  public void a(String paramString)
  {
    paramString = a(paramString);
    if (TextUtils.isEmpty(paramString.jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CursorManager", 2, "[removeEditInfo] editInfo not exists");
      }
      return;
    }
    this.jdField_a_of_type_JavaUtilList.remove(paramString);
    a(a().jdField_c_of_type_Int, a().d, false);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    bepb localbepb = a(paramString);
    if (TextUtils.isEmpty(localbepb.jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.e("CursorManager", 2, "[updateUserCursorSelection] uin: " + paramString + " not in EditInfo");
      }
      return;
    }
    a(localbepb);
    localbepb.jdField_c_of_type_Int = paramInt1;
    localbepb.d = paramInt2;
    localbepb.jdField_a_of_type_Float = -1.0F;
    b(localbepb);
    if (QLog.isColorLevel()) {
      QLog.d("CursorManager", 2, "[updateUserCursorSelection] update cursor uin: " + paramString + ", start: " + paramInt1 + ", end: " + paramInt2);
    }
    a(a().jdField_c_of_type_Int, a().d, false);
  }
  
  public void a(String paramString, bepb parambepb)
  {
    if (!TextUtils.isEmpty(a(paramString).jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CursorManager", 2, "[addUserEditInfo] editInfo exists");
      }
      return;
    }
    this.jdField_a_of_type_JavaUtilList.add(parambepb);
  }
  
  public void a(String paramString1, String paramString2)
  {
    List localList = a();
    int i = 0;
    int j;
    int k;
    if (i < localList.size())
    {
      bepb localbepb = (bepb)localList.get(i);
      j = localbepb.jdField_c_of_type_Int;
      k = localbepb.d;
      Object localObject = null;
      for (;;)
      {
        try
        {
          if (paramString1.equals(localbepb.jdField_a_of_type_JavaLangString)) {
            continue;
          }
          bool = true;
          int[] arrayOfInt = belm.a(paramString2, j, k, bool);
          localObject = arrayOfInt;
        }
        catch (Throwable localThrowable)
        {
          boolean bool;
          QLog.e("CursorManager", 1, "[updateOtherSelectionByPushChangeset] cs: " + paramString2 + ", oldStart: " + j + ", oldEnd, " + k);
          continue;
        }
        if ((localObject != null) && (localObject.length == 2))
        {
          localbepb.jdField_c_of_type_Int = localObject[0];
          localbepb.d = localObject[1];
        }
        i += 1;
        break;
        bool = false;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b(String paramString)
  {
    paramString = belm.a(paramString, a().jdField_c_of_type_Int, a().d, true);
    int i = paramString[0];
    int j = paramString[1];
    a(i, j, true);
    if (QLog.isColorLevel()) {
      QLog.d("CursorManager", 2, "[updateMySelectionByPushChangeset] after range follow, curStart: " + i + ", curEnd: " + j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beop
 * JD-Core Version:    0.7.0.1
 */