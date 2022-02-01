import android.os.Bundle;

class avjr
  implements aaob
{
  avjr(avjq paramavjq) {}
  
  public void callback(Bundle paramBundle)
  {
    int i = paramBundle.getInt("msg");
    if (i == 90)
    {
      avjq.a(this.a, paramBundle.getInt("state"));
      avjq.a(this.a, avjq.a(this.a), avjq.b(this.a));
    }
    while (i != 91) {
      return;
    }
    i = paramBundle.getInt("errCode");
    paramBundle = paramBundle.getString("desc");
    avjq.a(this.a, i, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avjr
 * JD-Core Version:    0.7.0.1
 */