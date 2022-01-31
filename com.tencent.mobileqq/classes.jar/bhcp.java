import android.view.View;

public final class bhcp
{
  public static boolean a(View paramView)
  {
    Object localObject = paramView.getTag(2131296645);
    long l = System.currentTimeMillis();
    paramView.setTag(2131296645, Long.valueOf(l));
    return ((localObject instanceof Long)) && (Math.abs(l - ((Long)localObject).longValue()) <= 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhcp
 * JD-Core Version:    0.7.0.1
 */