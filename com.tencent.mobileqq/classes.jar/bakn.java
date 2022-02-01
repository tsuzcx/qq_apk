import com.tencent.qphone.base.util.QLog;

public class bakn
{
  private bakr a;
  
  public bakn(bakr parambakr)
  {
    this.a = parambakr;
  }
  
  public bajr a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("CommandFactory", 2, "createCommand exception commandType = " + paramInt);
      }
      return null;
    case 1: 
      return new bajs(this.a);
    case 2: 
      return new bakc(this.a);
    case 0: 
      return new bajq(this.a);
    case 3: 
      return new bakb(this.a);
    case 4: 
      return new bajy(this.a);
    case 5: 
      return new bajw(this.a);
    case 11: 
      return new bajt(this.a);
    case 6: 
      return new bajx(this.a);
    case 7: 
      return new baju(this.a);
    case 8: 
      return new bajo(this.a);
    case 9: 
      return new baka(this.a);
    case 10: 
      return new bajp(this.a);
    case 12: 
      return new bajv(this.a);
    case 13: 
      return new bajn(this.a);
    }
    return new bajz(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bakn
 * JD-Core Version:    0.7.0.1
 */