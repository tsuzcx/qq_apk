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

public class bdhm
{
  private bdhn jdField_a_of_type_Bdhn;
  private bdhy jdField_a_of_type_Bdhy;
  private List<bdhy> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  public bdhm(bdhy parambdhy, List<bdhy> paramList)
  {
    this.jdField_a_of_type_Bdhy = parambdhy;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  @NotNull
  private List<bdhy> a(int paramInt, List<bdhy> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramList.size())
    {
      bdhy localbdhy = (bdhy)paramList.get(i);
      if (localbdhy != null)
      {
        if (paramInt != localbdhy.jdField_c_of_type_Int) {
          break label70;
        }
        localbdhy.jdField_a_of_type_Boolean = true;
        localArrayList.add(localbdhy);
      }
      for (;;)
      {
        i += 1;
        break;
        label70:
        if (localbdhy.jdField_c_of_type_Boolean) {
          localbdhy.jdField_a_of_type_Boolean = false;
        }
      }
    }
    return localArrayList;
  }
  
  private void a(bdhy parambdhy)
  {
    if (!parambdhy.jdField_c_of_type_Boolean)
    {
      parambdhy.jdField_a_of_type_Boolean = true;
      ThreadManagerV2.getUIHandlerV2().postDelayed(new CursorManager.1(this, parambdhy), 2000L);
    }
  }
  
  private void a(List<bdhy> paramList)
  {
    if (QLog.isColorLevel())
    {
      int i = 0;
      while (i < paramList.size())
      {
        QLog.d("CursorManager", 2, "[updateMyEditInfo] info: " + ((bdhy)paramList.get(i)).toString());
        i += 1;
      }
    }
  }
  
  private void a(List<bdhy> paramList1, List<bdhy> paramList2, int paramInt)
  {
    String str = "等" + paramInt + "人";
    int i = 0;
    bdhy localbdhy;
    while (i < paramInt)
    {
      localbdhy = (bdhy)paramList2.get(i);
      if (localbdhy != null) {
        localbdhy.jdField_a_of_type_Boolean = false;
      }
      i += 1;
    }
    paramList2 = (bdhy)paramList2.get(paramInt - 1);
    if (paramList2 != null)
    {
      localbdhy = new bdhy(paramList2);
      localbdhy.jdField_b_of_type_Boolean = true;
      localbdhy.jdField_a_of_type_Boolean = true;
      paramList2.jdField_b_of_type_JavaLangString += str;
      paramList1.add(localbdhy);
    }
  }
  
  private void b(bdhy parambdhy)
  {
    int i = this.jdField_a_of_type_JavaUtilList.indexOf(parambdhy);
    if (i != -1) {
      Collections.swap(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilList.size() - 1, i);
    }
  }
  
  private void b(List<bdhy> paramList)
  {
    if (paramList == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      bdhy localbdhy = (bdhy)paramList.get(i);
      if ((localbdhy != null) && (localbdhy.jdField_b_of_type_Boolean)) {
        localArrayList.add(localbdhy);
      }
      i += 1;
    }
    paramList.removeAll(localArrayList);
  }
  
  public bdhy a()
  {
    return this.jdField_a_of_type_Bdhy;
  }
  
  protected bdhy a(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString))
    {
      localObject = new bdhy();
      return localObject;
    }
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilList);
    int i = 0;
    label32:
    if (i < localArrayList.size())
    {
      localObject = (bdhy)localArrayList.get(i);
      if ((localObject == null) || (!paramString.equals(((bdhy)localObject).jdField_a_of_type_JavaLangString))) {}
    }
    for (paramString = (String)localObject;; paramString = null)
    {
      localObject = paramString;
      if (paramString != null) {
        break;
      }
      return new bdhy();
      i += 1;
      break label32;
    }
  }
  
  public Pair<Integer, Integer> a()
  {
    return new Pair(Integer.valueOf(this.jdField_a_of_type_Bdhy.jdField_c_of_type_Int), Integer.valueOf(this.jdField_a_of_type_Bdhy.d));
  }
  
  public List<bdhy> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Bdhy.jdField_c_of_type_Int = paramInt1;
    this.jdField_a_of_type_Bdhy.d = paramInt2;
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
    if (this.jdField_a_of_type_Bdhn != null)
    {
      this.jdField_a_of_type_Bdhn.c();
      if (paramBoolean) {
        this.jdField_a_of_type_Bdhn.a(paramInt1, paramInt2);
      }
    }
  }
  
  public void a(bdhn parambdhn)
  {
    this.jdField_a_of_type_Bdhn = parambdhn;
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
    bdhy localbdhy = a(paramString);
    if (TextUtils.isEmpty(localbdhy.jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.e("CursorManager", 2, "[updateUserCursorSelection] uin: " + paramString + " not in EditInfo");
      }
      return;
    }
    a(localbdhy);
    localbdhy.jdField_c_of_type_Int = paramInt1;
    localbdhy.d = paramInt2;
    localbdhy.jdField_a_of_type_Float = -1.0F;
    b(localbdhy);
    if (QLog.isColorLevel()) {
      QLog.d("CursorManager", 2, "[updateUserCursorSelection] update cursor uin: " + paramString + ", start: " + paramInt1 + ", end: " + paramInt2);
    }
    a(a().jdField_c_of_type_Int, a().d, false);
  }
  
  public void a(String paramString, bdhy parambdhy)
  {
    if (!TextUtils.isEmpty(a(paramString).jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CursorManager", 2, "[addUserEditInfo] editInfo exists");
      }
      return;
    }
    this.jdField_a_of_type_JavaUtilList.add(parambdhy);
  }
  
  public void a(String paramString1, String paramString2)
  {
    List localList = a();
    int i = 0;
    int j;
    int k;
    if (i < localList.size())
    {
      bdhy localbdhy = (bdhy)localList.get(i);
      j = localbdhy.jdField_c_of_type_Int;
      k = localbdhy.d;
      Object localObject = null;
      for (;;)
      {
        try
        {
          if (paramString1.equals(localbdhy.jdField_a_of_type_JavaLangString)) {
            continue;
          }
          bool = true;
          int[] arrayOfInt = bdej.a(paramString2, j, k, bool);
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
          localbdhy.jdField_c_of_type_Int = localObject[0];
          localbdhy.d = localObject[1];
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
    paramString = bdej.a(paramString, a().jdField_c_of_type_Int, a().d, true);
    int i = paramString[0];
    int j = paramString[1];
    a(i, j, true);
    if (QLog.isColorLevel()) {
      QLog.d("CursorManager", 2, "[updateMySelectionByPushChangeset] after range follow, curStart: " + i + ", curEnd: " + j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdhm
 * JD-Core Version:    0.7.0.1
 */