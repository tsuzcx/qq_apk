import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.extendfriend.bean.GroupInfo;
import java.util.ArrayList;
import java.util.List;

public class anoj
  implements ajfe
{
  protected void a(int paramInt) {}
  
  protected void a(boolean paramBoolean) {}
  
  protected void a(boolean paramBoolean, int paramInt1, int paramInt2, anpe paramanpe, int paramInt3) {}
  
  protected void a(boolean paramBoolean, int paramInt, anpe paramanpe) {}
  
  protected void a(boolean paramBoolean, int paramInt, anpe paramanpe, String paramString) {}
  
  protected void a(boolean paramBoolean1, long paramLong, String paramString, boolean paramBoolean2, byte[] paramArrayOfByte, boolean paramBoolean3, boolean paramBoolean4, int paramInt, List<anpv> paramList, anpd paramanpd) {}
  
  protected void a(boolean paramBoolean, anor paramanor) {}
  
  protected void a(boolean paramBoolean, anpe paramanpe) {}
  
  protected void a(boolean paramBoolean, anpv paramanpv, int paramInt) {}
  
  protected void a(boolean paramBoolean, Card paramCard) {}
  
  protected void a(boolean paramBoolean1, ArrayList<anpw> paramArrayList, boolean paramBoolean2) {}
  
  protected void a(boolean paramBoolean1, List<GroupInfo> paramList, boolean paramBoolean2, long paramLong, boolean paramBoolean3) {}
  
  protected void b(boolean paramBoolean) {}
  
  protected void c(boolean paramBoolean) {}
  
  protected void d(boolean paramBoolean) {}
  
  protected void e(boolean paramBoolean) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    case 10: 
    default: 
    case 1: 
    case 2: 
    case 3: 
    case 9: 
    case 4: 
      do
      {
        do
        {
          do
          {
            return;
            a(paramBoolean);
            return;
          } while ((paramObject == null) || (!(paramObject instanceof Object[])));
          paramObject = (Object[])paramObject;
          if ((paramBoolean) && (paramObject.length == 9))
          {
            a(true, ((Long)paramObject[0]).longValue(), (String)paramObject[1], ((Boolean)paramObject[2]).booleanValue(), (byte[])paramObject[3], ((Boolean)paramObject[4]).booleanValue(), ((Boolean)paramObject[5]).booleanValue(), ((Integer)paramObject[6]).intValue(), (List)paramObject[7], (anpd)paramObject[8]);
            return;
          }
        } while ((paramBoolean) || (paramObject.length != 2));
        a(false, ((Long)paramObject[0]).longValue(), (String)paramObject[1], false, null, false, false, 0, null, null);
        return;
        a(paramBoolean, (Card)paramObject);
        return;
        paramObject = (Object[])paramObject;
        a(paramBoolean, (anpv)paramObject[0], ((Integer)paramObject[1]).intValue());
        return;
      } while ((paramObject == null) || (!(paramObject instanceof Object[])));
      paramObject = (Object[])paramObject;
      a(paramBoolean, (List)paramObject[0], ((Boolean)paramObject[1]).booleanValue(), ((Long)paramObject[2]).longValue(), ((Boolean)paramObject[3]).booleanValue());
      return;
    case 5: 
      b(((Boolean)paramObject).booleanValue());
      return;
    case 8: 
      c(((Boolean)paramObject).booleanValue());
      return;
    case 6: 
      if ((paramObject instanceof Object[]))
      {
        paramObject = (Object[])paramObject;
        if (paramObject.length == 4)
        {
          a(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Integer)paramObject[1]).intValue(), (anpe)paramObject[2], ((Integer)paramObject[3]).intValue());
          return;
        }
        a(paramBoolean, -1, -1, null, -1);
        return;
      }
      a(paramBoolean, -1, -1, null, -1);
      return;
    case 7: 
      if ((paramObject instanceof Object[]))
      {
        paramObject = (Object[])paramObject;
        if ((paramObject != null) && (paramObject.length == 2))
        {
          a(paramBoolean, ((Integer)paramObject[0]).intValue(), (anpe)paramObject[1]);
          return;
        }
        a(false, -1, null);
        return;
      }
      a(paramBoolean, -1, null);
      return;
    case 11: 
      if (paramBoolean)
      {
        if ((paramObject != null) && ((paramObject instanceof Object[])))
        {
          paramObject = (Object[])paramObject;
          if ((paramObject != null) && (paramObject.length == 3))
          {
            a(paramBoolean, ((Integer)paramObject[0]).intValue(), (anpe)paramObject[1], (String)paramObject[2]);
            return;
          }
          a(false, -1, null, null);
          return;
        }
        a(false, -1, null, null);
        return;
      }
      a(false, -1, null, null);
      return;
    case 16: 
      if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof Object[])))
      {
        paramObject = (Object[])paramObject;
        if ((paramObject != null) && (paramObject.length == 1))
        {
          a(paramBoolean, (anpe)paramObject[0]);
          return;
        }
        a(false, null);
        return;
      }
      a(false, null);
      return;
    case 12: 
      d(paramBoolean);
      return;
    case 13: 
      if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof Object[])))
      {
        paramObject = (Object[])paramObject;
        if ((paramObject != null) && (paramObject.length == 2))
        {
          a(true, (ArrayList)paramObject[0], ((Boolean)paramObject[1]).booleanValue());
          return;
        }
        a(false, null, true);
        return;
      }
      a(false, null, true);
      return;
    case 14: 
      e(paramBoolean);
      return;
    case 15: 
      if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof Object[])))
      {
        paramObject = (Object[])paramObject;
        if ((paramObject != null) && (paramObject.length == 1))
        {
          a(true, (anor)paramObject[0]);
          return;
        }
        a(false, null);
        return;
      }
      a(false, null);
      return;
    }
    a(((Integer)paramObject).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     anoj
 * JD-Core Version:    0.7.0.1
 */