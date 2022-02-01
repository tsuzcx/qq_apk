import android.view.View;

public class avxr
  implements avxa
{
  public void a(avxb paramavxb)
  {
    paramavxb.a();
  }
  
  public void a(View... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      paramVarArgs[i].setVisibility(0);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avxr
 * JD-Core Version:    0.7.0.1
 */