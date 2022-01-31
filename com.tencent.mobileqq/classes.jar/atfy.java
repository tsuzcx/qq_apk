import android.graphics.Bitmap;
import java.util.List;

public class atfy
{
  protected void a() {}
  
  protected void a(int paramInt, String paramString) {}
  
  protected void a(int paramInt, String paramString, Bitmap paramBitmap) {}
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
    case 4118: 
    case 4131: 
      do
      {
        do
        {
          return;
        } while ((paramVarArgs == null) || (paramVarArgs.length != 2));
        a((List)paramVarArgs[0], (List)paramVarArgs[1]);
        return;
      } while ((paramVarArgs == null) || (paramVarArgs.length != 2));
      a(((Integer)paramVarArgs[0]).intValue(), ((Boolean)paramVarArgs[1]).booleanValue());
      return;
    case 4113: 
      a(((Boolean)paramVarArgs[0]).booleanValue(), (List)paramVarArgs[1]);
      return;
    case 4114: 
      b(((Boolean)paramVarArgs[0]).booleanValue(), (List)paramVarArgs[1]);
      return;
    case 4115: 
      a(((Boolean)paramVarArgs[0]).booleanValue(), null);
      return;
    case 4116: 
      a(((Boolean)paramVarArgs[0]).booleanValue(), null);
      return;
    case 4159: 
      b();
      return;
    case 4161: 
      try
      {
        a(((Integer)paramVarArgs[0]).intValue(), (String)paramVarArgs[1], (Bitmap)paramVarArgs[2]);
        return;
      }
      catch (Exception paramVarArgs)
      {
        paramVarArgs.printStackTrace();
        return;
      }
    case 4162: 
      try
      {
        if (((Integer)paramVarArgs[0]).intValue() == 0)
        {
          a(((Integer)paramVarArgs[0]).intValue(), (String)paramVarArgs[1]);
          return;
        }
      }
      catch (Exception paramVarArgs)
      {
        paramVarArgs.printStackTrace();
        return;
      }
      b(((Integer)paramVarArgs[0]).intValue(), (String)paramVarArgs[1]);
      return;
    }
    try
    {
      a();
      return;
    }
    catch (Exception paramVarArgs)
    {
      paramVarArgs.printStackTrace();
    }
  }
  
  public void a(List<String> paramList1, List<String> paramList2) {}
  
  protected void a(boolean paramBoolean, String paramString) {}
  
  public void a(boolean paramBoolean, List<Long> paramList) {}
  
  protected void a(boolean paramBoolean, Object[] paramArrayOfObject) {}
  
  protected void b() {}
  
  protected void b(int paramInt, String paramString) {}
  
  public void b(boolean paramBoolean, List<Long> paramList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atfy
 * JD-Core Version:    0.7.0.1
 */