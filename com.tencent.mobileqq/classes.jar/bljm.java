import android.view.View;

public final class bljm
{
  public static boolean a(View paramView)
  {
    Object localObject = paramView.getTag(2131362202);
    long l = System.currentTimeMillis();
    paramView.setTag(2131362202, Long.valueOf(l));
    return ((localObject instanceof Long)) && (Math.abs(l - ((Long)localObject).longValue()) <= 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bljm
 * JD-Core Version:    0.7.0.1
 */