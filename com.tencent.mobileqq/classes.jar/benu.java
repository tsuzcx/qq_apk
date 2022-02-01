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

public class benu
{
  private benv jdField_a_of_type_Benv;
  private beog jdField_a_of_type_Beog;
  private List<beog> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  
  public benu(beog parambeog, List<beog> paramList)
  {
    this.jdField_a_of_type_Beog = parambeog;
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  @NotNull
  private List<beog> a(int paramInt, List<beog> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramList.size())
    {
      beog localbeog = (beog)paramList.get(i);
      if (localbeog != null)
      {
        if (paramInt != localbeog.jdField_c_of_type_Int) {
          break label70;
        }
        localbeog.jdField_a_of_type_Boolean = true;
        localArrayList.add(localbeog);
      }
      for (;;)
      {
        i += 1;
        break;
        label70:
        if (localbeog.jdField_c_of_type_Boolean) {
          localbeog.jdField_a_of_type_Boolean = false;
        }
      }
    }
    return localArrayList;
  }
  
  private void a(beog parambeog)
  {
    if (!parambeog.jdField_c_of_type_Boolean)
    {
      parambeog.jdField_a_of_type_Boolean = true;
      ThreadManagerV2.getUIHandlerV2().postDelayed(new CursorManager.1(this, parambeog), 2000L);
    }
  }
  
  private void a(List<beog> paramList)
  {
    if (QLog.isColorLevel())
    {
      int i = 0;
      while (i < paramList.size())
      {
        QLog.d("CursorManager", 2, "[updateMyEditInfo] info: " + ((beog)paramList.get(i)).toString());
        i += 1;
      }
    }
  }
  
  private void a(List<beog> paramList1, List<beog> paramList2, int paramInt)
  {
    String str = "等" + paramInt + "人";
    int i = 0;
    beog localbeog;
    while (i < paramInt)
    {
      localbeog = (beog)paramList2.get(i);
      if (localbeog != null) {
        localbeog.jdField_a_of_type_Boolean = false;
      }
      i += 1;
    }
    paramList2 = (beog)paramList2.get(paramInt - 1);
    if (paramList2 != null)
    {
      localbeog = new beog(paramList2);
      localbeog.jdField_b_of_type_Boolean = true;
      localbeog.jdField_a_of_type_Boolean = true;
      paramList2.jdField_b_of_type_JavaLangString += str;
      paramList1.add(localbeog);
    }
  }
  
  private void b(beog parambeog)
  {
    int i = this.jdField_a_of_type_JavaUtilList.indexOf(parambeog);
    if (i != -1) {
      Collections.swap(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_JavaUtilList.size() - 1, i);
    }
  }
  
  private void b(List<beog> paramList)
  {
    if (paramList == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      beog localbeog = (beog)paramList.get(i);
      if ((localbeog != null) && (localbeog.jdField_b_of_type_Boolean)) {
        localArrayList.add(localbeog);
      }
      i += 1;
    }
    paramList.removeAll(localArrayList);
  }
  
  public beog a()
  {
    return this.jdField_a_of_type_Beog;
  }
  
  protected beog a(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString))
    {
      localObject = new beog();
      return localObject;
    }
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilList);
    int i = 0;
    label32:
    if (i < localArrayList.size())
    {
      localObject = (beog)localArrayList.get(i);
      if ((localObject == null) || (!paramString.equals(((beog)localObject).jdField_a_of_type_JavaLangString))) {}
    }
    for (paramString = (String)localObject;; paramString = null)
    {
      localObject = paramString;
      if (paramString != null) {
        break;
      }
      return new beog();
      i += 1;
      break label32;
    }
  }
  
  public Pair<Integer, Integer> a()
  {
    return new Pair(Integer.valueOf(this.jdField_a_of_type_Beog.jdField_c_of_type_Int), Integer.valueOf(this.jdField_a_of_type_Beog.d));
  }
  
  public List<beog> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Beog.jdField_c_of_type_Int = paramInt1;
    this.jdField_a_of_type_Beog.d = paramInt2;
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
    if (this.jdField_a_of_type_Benv != null)
    {
      this.jdField_a_of_type_Benv.c();
      if (paramBoolean) {
        this.jdField_a_of_type_Benv.a(paramInt1, paramInt2);
      }
    }
  }
  
  public void a(benv parambenv)
  {
    this.jdField_a_of_type_Benv = parambenv;
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
    beog localbeog = a(paramString);
    if (TextUtils.isEmpty(localbeog.jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.e("CursorManager", 2, "[updateUserCursorSelection] uin: " + paramString + " not in EditInfo");
      }
      return;
    }
    a(localbeog);
    localbeog.jdField_c_of_type_Int = paramInt1;
    localbeog.d = paramInt2;
    localbeog.jdField_a_of_type_Float = -1.0F;
    b(localbeog);
    if (QLog.isColorLevel()) {
      QLog.d("CursorManager", 2, "[updateUserCursorSelection] update cursor uin: " + paramString + ", start: " + paramInt1 + ", end: " + paramInt2);
    }
    a(a().jdField_c_of_type_Int, a().d, false);
  }
  
  public void a(String paramString, beog parambeog)
  {
    if (!TextUtils.isEmpty(a(paramString).jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CursorManager", 2, "[addUserEditInfo] editInfo exists");
      }
      return;
    }
    this.jdField_a_of_type_JavaUtilList.add(parambeog);
  }
  
  public void a(String paramString1, String paramString2)
  {
    List localList = a();
    int i = 0;
    int j;
    int k;
    if (i < localList.size())
    {
      beog localbeog = (beog)localList.get(i);
      j = localbeog.jdField_c_of_type_Int;
      k = localbeog.d;
      Object localObject = null;
      for (;;)
      {
        try
        {
          if (paramString1.equals(localbeog.jdField_a_of_type_JavaLangString)) {
            continue;
          }
          bool = true;
          int[] arrayOfInt = beks.a(paramString2, j, k, bool);
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
          localbeog.jdField_c_of_type_Int = localObject[0];
          localbeog.d = localObject[1];
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
    paramString = beks.a(paramString, a().jdField_c_of_type_Int, a().d, true);
    int i = paramString[0];
    int j = paramString[1];
    a(i, j, true);
    if (QLog.isColorLevel()) {
      QLog.d("CursorManager", 2, "[updateMySelectionByPushChangeset] after range follow, curStart: " + i + ", curEnd: " + j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     benu
 * JD-Core Version:    0.7.0.1
 */