import com.tencent.qphone.base.util.QLog;

public class azew
{
  private azfa a;
  
  public azew(azfa paramazfa)
  {
    this.a = paramazfa;
  }
  
  public azeb a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("CommandFactory", 2, "createCommand exception commandType = " + paramInt);
      }
      return null;
    case 1: 
      return new azec(this.a);
    case 2: 
      return new azel(this.a);
    case 0: 
      return new azea(this.a);
    case 3: 
      return new azek(this.a);
    case 4: 
      return new azei(this.a);
    case 5: 
      return new azeg(this.a);
    case 11: 
      return new azed(this.a);
    case 6: 
      return new azeh(this.a);
    case 7: 
      return new azee(this.a);
    case 8: 
      return new azdy(this.a);
    case 9: 
      return new azej(this.a);
    case 10: 
      return new azdz(this.a);
    }
    return new azef(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azew
 * JD-Core Version:    0.7.0.1
 */