import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import com.tencent.troop.group_activity_info.GroupActInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import tencent.qun.group_activity.group_activity.GroupAct;

public class anif
  implements anil
{
  private final String a = "BizTroopObserver";
  
  private void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 2) {
      return;
    }
    c(paramBoolean, paramObject);
  }
  
  private void a(int paramInt, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (paramInt != 6) {}
    while (paramArrayOfObject == null) {
      return;
    }
    if (paramBoolean)
    {
      a(paramBoolean, (String)paramArrayOfObject[0], ((Boolean)paramArrayOfObject[1]).booleanValue(), (List)paramArrayOfObject[2]);
      return;
    }
    a(paramBoolean, (String)paramArrayOfObject[0], ((Boolean)paramArrayOfObject[1]).booleanValue(), null);
  }
  
  private void b(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 9) {
      return;
    }
    a(paramObject);
  }
  
  private void b(int paramInt, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (paramInt != 12) {}
    while (paramArrayOfObject == null) {
      return;
    }
    if (paramBoolean)
    {
      a(true, ((Integer)paramArrayOfObject[0]).intValue(), ((Integer)paramArrayOfObject[1]).intValue(), ((Integer)paramArrayOfObject[2]).intValue(), (ArrayList)paramArrayOfObject[3], 0);
      return;
    }
    a(false, ((Integer)paramArrayOfObject[2]).intValue(), 0, 0, null, ((Integer)paramArrayOfObject[4]).intValue());
  }
  
  private void c(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 8) {
      return;
    }
    d(paramBoolean, paramObject);
  }
  
  private void c(int paramInt, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (paramInt != 18) {}
    while (paramArrayOfObject == null) {
      return;
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfObject.length == 5)
    {
      localObject1 = localObject2;
      if (paramArrayOfObject[4] != null) {
        localObject1 = (String)paramArrayOfObject[4];
      }
    }
    a((String)paramArrayOfObject[0], ((Integer)paramArrayOfObject[1]).intValue(), ((Integer)paramArrayOfObject[2]).intValue(), (String)paramArrayOfObject[3], (String)localObject1);
  }
  
  private void d(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 10) {
      return;
    }
    e(paramBoolean, paramObject);
  }
  
  private void d(int paramInt, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    int i = 0;
    if (paramInt != 42) {}
    do
    {
      return;
      if ((paramArrayOfObject != null) && (paramArrayOfObject.length > 0)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("BizTroopObserver", 2, "onUpdate(), case BizTroopHandler.TYPE_SET_COMMONLY_USED_TROOP_LIST, array is null or empty ...");
    return;
    Map localMap;
    if ((paramArrayOfObject[0] instanceof Integer))
    {
      paramInt = ((Integer)paramArrayOfObject[0]).intValue();
      if ((paramArrayOfObject[1] instanceof Integer)) {
        i = ((Integer)paramArrayOfObject[1]).intValue();
      }
      if (!(paramArrayOfObject[2] instanceof Map)) {
        break label122;
      }
      localMap = (Map)paramArrayOfObject[2];
      label90:
      if (!(paramArrayOfObject[3] instanceof String)) {
        break label128;
      }
    }
    label128:
    for (paramArrayOfObject = (String)paramArrayOfObject[3];; paramArrayOfObject = null)
    {
      a(paramInt, i, localMap, paramArrayOfObject);
      return;
      paramInt = -1;
      break;
      label122:
      localMap = null;
      break label90;
    }
  }
  
  private void e(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 11) {
      return;
    }
    a(paramBoolean, (List)paramObject);
  }
  
  private void e(int paramInt, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (paramInt != 29) {
      return;
    }
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length == 0))
    {
      a(false, -1L, "");
      return;
    }
    a(paramBoolean, ((Long)paramArrayOfObject[0]).longValue(), (String)paramArrayOfObject[1]);
  }
  
  private void f(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 13) {
      return;
    }
    b(paramObject);
  }
  
  private void f(int paramInt, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (paramInt != 32) {}
    while (paramArrayOfObject == null) {
      return;
    }
    a(paramBoolean, ((Long)paramArrayOfObject[0]).longValue(), ((Long)paramArrayOfObject[1]).longValue());
  }
  
  private void g(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 20) {
      return;
    }
    c(paramObject);
  }
  
  private void g(int paramInt, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (paramInt != 33) {}
    while (paramArrayOfObject == null) {
      return;
    }
    a(paramBoolean, ((Integer)paramArrayOfObject[1]).intValue(), ((Integer)paramArrayOfObject[2]).intValue());
  }
  
  private void h(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 19) {}
  }
  
  private void h(int paramInt, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (paramInt != 31) {}
    while (paramArrayOfObject == null) {
      return;
    }
    b(paramBoolean, ((Boolean)paramArrayOfObject[1]).booleanValue());
  }
  
  private void i(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 27) {
      return;
    }
    f(paramBoolean, paramObject);
  }
  
  private void i(int paramInt, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (paramInt != 38) {
      return;
    }
    if ((paramBoolean) && (paramArrayOfObject != null))
    {
      a(((Long)paramArrayOfObject[0]).longValue(), ((Long)paramArrayOfObject[1]).longValue(), ((Long)paramArrayOfObject[2]).longValue(), (String)paramArrayOfObject[3]);
      return;
    }
    a(-1L, -1L, -1L, "");
  }
  
  private void j(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 28) {
      return;
    }
    g(paramBoolean, paramObject);
  }
  
  private void j(int paramInt, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (paramInt != 41) {
      return;
    }
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length >= 1)) {}
    for (paramInt = ((Integer)paramArrayOfObject[0]).intValue(); (paramBoolean) && (paramArrayOfObject != null) && (paramArrayOfObject.length >= 4); paramInt = 2131695434)
    {
      a(paramBoolean, paramInt, (String)paramArrayOfObject[1], (String)paramArrayOfObject[2], (Boolean)paramArrayOfObject[3]);
      return;
    }
    a(paramBoolean, paramInt, null, null, Boolean.valueOf(true));
  }
  
  private void k(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 21) {
      return;
    }
    j(paramBoolean, paramObject);
  }
  
  private void k(int paramInt, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (paramInt != 43) {}
    while (paramArrayOfObject == null) {
      return;
    }
    if (paramArrayOfObject.length >= 4) {}
    for (paramInt = ((Integer)paramArrayOfObject[3]).intValue();; paramInt = 0)
    {
      a(paramBoolean, (String)paramArrayOfObject[0], (String)paramArrayOfObject[1], (String)paramArrayOfObject[2], paramInt);
      return;
    }
  }
  
  private void l(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 22) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("BizTroopObserver", 4, "TroopHandler.TYPE_TROOP_GAG_STATUS");
    }
    a((bfsn)paramObject);
  }
  
  private void l(int paramInt, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (paramInt != 50) {}
    while (paramArrayOfObject == null) {
      return;
    }
    a((bety)paramArrayOfObject[0], ((Integer)paramArrayOfObject[1]).intValue(), ((Integer)paramArrayOfObject[2]).intValue(), (String)paramArrayOfObject[3], (String)paramArrayOfObject[4], (Bundle)paramArrayOfObject[5]);
  }
  
  private void m(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 30) {
      return;
    }
    a(paramBoolean, ((Boolean)paramObject).booleanValue());
  }
  
  private void n(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 24) {
      return;
    }
    k(paramBoolean, paramObject);
  }
  
  private void o(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 36) {
      return;
    }
    a(paramBoolean, paramObject);
  }
  
  private void p(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 44) {
      return;
    }
    b(paramBoolean, paramObject);
  }
  
  private void q(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 39) {
      return;
    }
    h(paramBoolean, paramObject);
  }
  
  private void r(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 40) {
      return;
    }
    i(paramBoolean, paramObject);
  }
  
  public void a(int paramInt1, int paramInt2, Map<String, Integer> paramMap, String paramString) {}
  
  protected void a(long paramLong1, long paramLong2, long paramLong3, String paramString) {}
  
  protected void a(bety parambety, int paramInt1, int paramInt2, String paramString1, String paramString2, Bundle paramBundle) {}
  
  protected void a(bfsn parambfsn) {}
  
  protected void a(Object paramObject) {}
  
  protected void a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3) {}
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, ArrayList<bfpr> paramArrayList, int paramInt4) {}
  
  protected void a(boolean paramBoolean, int paramInt, String paramString1, String paramString2, Boolean paramBoolean1) {}
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2) {}
  
  protected void a(boolean paramBoolean, long paramLong, String paramString) {}
  
  protected void a(boolean paramBoolean, Object paramObject) {}
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt) {}
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2, List<group_activity_info.GroupActInfo> paramList) {}
  
  protected void a(boolean paramBoolean, List<group_activity.GroupAct> paramList) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void b(Object paramObject) {}
  
  protected void b(boolean paramBoolean, Object paramObject) {}
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void c(Object paramObject) {}
  
  protected void c(boolean paramBoolean, Object paramObject) {}
  
  protected void d(boolean paramBoolean, Object paramObject) {}
  
  protected void e(boolean paramBoolean, Object paramObject) {}
  
  protected void f(boolean paramBoolean, Object paramObject) {}
  
  protected void g(boolean paramBoolean, Object paramObject) {}
  
  protected void h(boolean paramBoolean, Object paramObject) {}
  
  protected void i(boolean paramBoolean, Object paramObject) {}
  
  protected void j(boolean paramBoolean, Object paramObject) {}
  
  protected void k(boolean paramBoolean, Object paramObject) {}
  
  public final void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    Object[] arrayOfObject = null;
    if ((paramObject instanceof Object[])) {
      arrayOfObject = (Object[])paramObject;
    }
    a(paramInt, paramBoolean, paramObject);
    b(paramInt, paramBoolean, paramObject);
    a(paramInt, paramBoolean, arrayOfObject);
    c(paramInt, paramBoolean, paramObject);
    d(paramInt, paramBoolean, paramObject);
    e(paramInt, paramBoolean, paramObject);
    b(paramInt, paramBoolean, arrayOfObject);
    f(paramInt, paramBoolean, paramObject);
    g(paramInt, paramBoolean, paramObject);
    c(paramInt, paramBoolean, arrayOfObject);
    d(paramInt, paramBoolean, arrayOfObject);
    h(paramInt, paramBoolean, paramObject);
    i(paramInt, paramBoolean, paramObject);
    j(paramInt, paramBoolean, paramObject);
    e(paramInt, paramBoolean, arrayOfObject);
    k(paramInt, paramBoolean, paramObject);
    l(paramInt, paramBoolean, paramObject);
    m(paramInt, paramBoolean, paramObject);
    n(paramInt, paramBoolean, paramObject);
    f(paramInt, paramBoolean, arrayOfObject);
    g(paramInt, paramBoolean, arrayOfObject);
    h(paramInt, paramBoolean, arrayOfObject);
    o(paramInt, paramBoolean, paramObject);
    p(paramInt, paramBoolean, paramObject);
    i(paramInt, paramBoolean, arrayOfObject);
    q(paramInt, paramBoolean, paramObject);
    r(paramInt, paramBoolean, paramObject);
    j(paramInt, paramBoolean, arrayOfObject);
    k(paramInt, paramBoolean, arrayOfObject);
    l(paramInt, paramBoolean, arrayOfObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anif
 * JD-Core Version:    0.7.0.1
 */