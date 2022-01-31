public class askw
  implements ajte
{
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, asma paramasma) {}
  
  public void a(boolean paramBoolean, Object paramObject) {}
  
  public void b(boolean paramBoolean) {}
  
  public void b(boolean paramBoolean, Object paramObject) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      a(paramBoolean, paramObject);
      return;
    case 2: 
      b(paramBoolean, paramObject);
      return;
    case 3: 
      a(paramBoolean);
      return;
    case 4: 
      a(paramBoolean, (asma)paramObject);
      return;
    }
    b(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     askw
 * JD-Core Version:    0.7.0.1
 */