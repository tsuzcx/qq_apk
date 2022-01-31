import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardPhotoOption;
import com.tencent.mobileqq.forward.ForwardShortVideoOption;
import com.tencent.qphone.base.util.QLog;

public class aqdm
{
  public static aqbe a(Intent paramIntent)
  {
    aqcg localaqcg = null;
    int i = paramIntent.getIntExtra("forward_type", -1);
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardOptionBuilder", 2, "ForwardOptionBuilder forwardType=" + i);
    }
    if (i == 0) {
      localaqcg = new aqcg(paramIntent);
    }
    do
    {
      return localaqcg;
      if (i == 1) {
        return new ForwardPhotoOption(paramIntent);
      }
      if (i == -1) {
        return new aqgo(paramIntent);
      }
      if (i == -2) {
        return new aqct(paramIntent);
      }
      if (i == -3) {
        return new aqgk(paramIntent);
      }
      if (i == 17) {
        return new aqfq(paramIntent);
      }
      if (i == 18) {
        return new aqcl(paramIntent);
      }
      if ((i == 20) || (i == 24)) {
        return new aqeo(paramIntent);
      }
      if (i == 42) {
        return new aqer(paramIntent);
      }
      if (i == 11) {
        return new aqfd(paramIntent);
      }
      if (i == 15) {
        return new aqbr(paramIntent);
      }
      if (i == 2) {
        return new aqem(paramIntent);
      }
      if (i == 12) {
        return new aqav(paramIntent);
      }
      if (i == 1001) {
        return new aqds(paramIntent);
      }
      if (i == -4) {
        return new aqco(paramIntent);
      }
      if (i == 13) {
        return new aqha(paramIntent);
      }
      if (i == 14) {
        return new aqcb(paramIntent);
      }
      if (i == 9) {
        return new aqcu(paramIntent);
      }
      if (i == 16) {
        return new aqfp(paramIntent);
      }
      if (i == 21) {
        return new ForwardShortVideoOption(paramIntent);
      }
      if (i == 22) {
        return new aqej(paramIntent);
      }
      if (i == 10) {
        return new aqbu(paramIntent);
      }
      if (i == 23) {
        return new aqgd(paramIntent);
      }
      if (i == 25) {
        return new aqcm(paramIntent);
      }
      if (i == 27) {
        return new aqbc(paramIntent);
      }
      if (i == 38) {
        return new aqba(paramIntent);
      }
      if (i == 35) {
        return new aqay(paramIntent);
      }
      if (i == 33) {
        return new aqaz(paramIntent);
      }
      if (i == 26) {
        return new aqaw(paramIntent);
      }
      if (i == -5) {
        return new aqcw(paramIntent);
      }
      if (i == 28) {
        return new aqel(paramIntent);
      }
      if (i == 29) {
        return new aqek(paramIntent);
      }
      if (i == 32) {
        return new aqgz(paramIntent);
      }
      if (i == 34) {
        return new aqax(paramIntent);
      }
      if (i == 36) {
        return new aqgq(paramIntent);
      }
      if (i == 37) {
        return new aqcn(paramIntent);
      }
      if (i == 39) {
        return new aqen(paramIntent);
      }
      if (i == 41) {
        return new aqck(paramIntent);
      }
    } while (i != -6);
    return new aqep(paramIntent);
  }
  
  public static aqbe a(Intent paramIntent, QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    paramIntent.putExtra("emoInputType", 2);
    paramIntent = a(paramIntent);
    if (paramIntent != null)
    {
      paramIntent.a(paramQQAppInterface, paramActivity);
      paramIntent.a();
    }
    return paramIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqdm
 * JD-Core Version:    0.7.0.1
 */