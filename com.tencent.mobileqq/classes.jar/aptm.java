import com.tencent.ark.ark.VariantWrapper;

class aptm
  extends aptp
{
  private aptm()
  {
    super(null);
  }
  
  public String a()
  {
    return "GetPskey";
  }
  
  public void a(apsl paramapsl, ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length == 1)) {
      paramVariantWrapper.SetString(apuj.b(paramArrayOfVariantWrapper[0].GetString()));
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public String b()
  {
    return null;
  }
  
  public boolean b()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aptm
 * JD-Core Version:    0.7.0.1
 */