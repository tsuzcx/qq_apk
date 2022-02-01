import com.tencent.qav.QavDef.MultiUserInfo;
import java.util.List;

public class bjub
  extends bjuk
{
  public void a() {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      a();
      return;
    case 2: 
      a(((Integer)paramVarArgs[0]).intValue());
      return;
    case 3: 
      a((QavDef.MultiUserInfo)paramVarArgs[0]);
      return;
    case 4: 
      b((QavDef.MultiUserInfo)paramVarArgs[0]);
      return;
    case 5: 
      a((QavDef.MultiUserInfo)paramVarArgs[0], ((Boolean)paramVarArgs[1]).booleanValue());
      return;
    case 6: 
      QavDef.MultiUserInfo localMultiUserInfo = (QavDef.MultiUserInfo)paramVarArgs[0];
      boolean bool = ((Boolean)paramVarArgs[1]).booleanValue();
      a(localMultiUserInfo, bool, ((Integer)paramVarArgs[2]).intValue());
      b(localMultiUserInfo, bool);
      return;
    case 7: 
      a((List)paramVarArgs[0]);
      return;
    case 8: 
      b(((Integer)paramVarArgs[0]).intValue());
      return;
    case 9: 
      a(true, ((Long)paramVarArgs[0]).longValue(), ((Long)paramVarArgs[1]).longValue(), ((Integer)paramVarArgs[2]).intValue(), ((Long)paramVarArgs[3]).longValue(), ((Integer)paramVarArgs[4]).intValue());
      return;
    case 10: 
      a(false, ((Long)paramVarArgs[0]).longValue(), ((Long)paramVarArgs[1]).longValue(), ((Integer)paramVarArgs[2]).intValue(), ((Long)paramVarArgs[3]).longValue(), ((Integer)paramVarArgs[4]).intValue());
      return;
    case 11: 
      a(((Boolean)paramVarArgs[0]).booleanValue(), ((Long)paramVarArgs[1]).longValue(), ((Integer)paramVarArgs[2]).intValue());
      return;
    case 12: 
      b(((Boolean)paramVarArgs[0]).booleanValue(), ((Long)paramVarArgs[1]).longValue(), ((Integer)paramVarArgs[2]).intValue());
      return;
    case 13: 
      a(((Long)paramVarArgs[0]).longValue(), ((Integer)paramVarArgs[1]).intValue());
      return;
    case 14: 
      a(((Long)paramVarArgs[0]).longValue(), ((Integer)paramVarArgs[1]).intValue(), ((Long)paramVarArgs[2]).longValue(), ((Integer)paramVarArgs[3]).intValue());
      return;
    case 15: 
      c(((Integer)paramVarArgs[0]).intValue());
      return;
    }
    a(((Boolean)paramVarArgs[0]).booleanValue());
  }
  
  public void a(long paramLong, int paramInt) {}
  
  public void a(long paramLong1, int paramInt1, long paramLong2, int paramInt2) {}
  
  public void a(QavDef.MultiUserInfo paramMultiUserInfo) {}
  
  public void a(QavDef.MultiUserInfo paramMultiUserInfo, boolean paramBoolean) {}
  
  public void a(QavDef.MultiUserInfo paramMultiUserInfo, boolean paramBoolean, int paramInt) {}
  
  public void a(List<QavDef.MultiUserInfo> paramList) {}
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, long paramLong, int paramInt) {}
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2, int paramInt1, long paramLong3, int paramInt2) {}
  
  public void b(int paramInt) {}
  
  public void b(QavDef.MultiUserInfo paramMultiUserInfo) {}
  
  public void b(QavDef.MultiUserInfo paramMultiUserInfo, boolean paramBoolean) {}
  
  public void b(boolean paramBoolean, long paramLong, int paramInt) {}
  
  public void c(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjub
 * JD-Core Version:    0.7.0.1
 */