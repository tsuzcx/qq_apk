import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;

public class aygo
  extends aygn
{
  private final int[] a = { 1104651886, 1106658188, 1107930043, 100729587, 1108164955, 1101487426, 101847385, 1104864062, 1104639410, 1106551782, 1106114157, 101761547, 101793773, 101817424, 1108481457, 1104864066, 1104864068, 101850591, 1104536706, 1104788679, 1108961705, 101849720 };
  private final int[] b = { 1104651886, 1106658188, 1107930043, 100729587, 1108164955, 1101487426, 101847385, 1104864062, 1104639410, 1106551782, 1106114157, 101761547, 101793773, 101817424, 1108481457, 1104864066, 1104864068, 101850591, 1104536706, 1104788679, 1108961705, 101849720, 101846357 };
  private int[] c = this.a;
  
  public void a(aygw paramaygw, QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    TroopInfo localTroopInfo = ((TroopManager)paramQQAppInterface.getManager(52)).c(paramString);
    if ((localTroopInfo != null) && (localTroopInfo.isHomeworkTroop())) {}
    for (this.c = this.b;; this.c = this.a)
    {
      super.a(paramaygw, paramQQAppInterface, paramInt, paramString);
      return;
    }
  }
  
  protected int[] a()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aygo
 * JD-Core Version:    0.7.0.1
 */