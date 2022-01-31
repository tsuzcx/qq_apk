import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardPhotoOption;
import com.tencent.mobileqq.forward.ForwardShortVideoOption;
import com.tencent.qphone.base.util.QLog;

public class asbd
{
  public static aryv a(Intent paramIntent)
  {
    arzx localarzx = null;
    int i = paramIntent.getIntExtra("forward_type", -1);
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardOptionBuilder", 2, "ForwardOptionBuilder forwardType=" + i);
    }
    if (i == 0) {
      localarzx = new arzx(paramIntent);
    }
    do
    {
      return localarzx;
      if (i == 1) {
        return new ForwardPhotoOption(paramIntent);
      }
      if (i == -1) {
        return new asem(paramIntent);
      }
      if (i == -2) {
        return new asak(paramIntent);
      }
      if (i == -3) {
        return new asei(paramIntent);
      }
      if (i == 17) {
        return new asdo(paramIntent);
      }
      if (i == 18) {
        return new asac(paramIntent);
      }
      if ((i == 20) || (i == 24)) {
        return new ascf(paramIntent);
      }
      if (i == 42) {
        return new asci(paramIntent);
      }
      if (i == 11) {
        return new asdb(paramIntent);
      }
      if (i == 15) {
        return new arzi(paramIntent);
      }
      if (i == 2) {
        return new ascd(paramIntent);
      }
      if (i == 12) {
        return new arym(paramIntent);
      }
      if (i == 1001) {
        return new asbj(paramIntent);
      }
      if (i == -4) {
        return new asaf(paramIntent);
      }
      if (i == 13) {
        return new asey(paramIntent);
      }
      if (i == 14) {
        return new arzs(paramIntent);
      }
      if (i == 9) {
        return new asal(paramIntent);
      }
      if (i == 16) {
        return new asdn(paramIntent);
      }
      if (i == 21) {
        return new ForwardShortVideoOption(paramIntent);
      }
      if (i == 22) {
        return new asca(paramIntent);
      }
      if (i == 10) {
        return new arzl(paramIntent);
      }
      if (i == 23) {
        return new aseb(paramIntent);
      }
      if (i == 25) {
        return new asad(paramIntent);
      }
      if (i == 27) {
        return new aryt(paramIntent);
      }
      if (i == 38) {
        return new aryr(paramIntent);
      }
      if (i == 35) {
        return new aryp(paramIntent);
      }
      if (i == 33) {
        return new aryq(paramIntent);
      }
      if (i == 26) {
        return new aryn(paramIntent);
      }
      if (i == -5) {
        return new asan(paramIntent);
      }
      if (i == 28) {
        return new ascc(paramIntent);
      }
      if (i == 29) {
        return new ascb(paramIntent);
      }
      if (i == 32) {
        return new asex(paramIntent);
      }
      if (i == 34) {
        return new aryo(paramIntent);
      }
      if (i == 36) {
        return new aseo(paramIntent);
      }
      if (i == 37) {
        return new asae(paramIntent);
      }
      if (i == 39) {
        return new asce(paramIntent);
      }
      if (i == 41) {
        return new asab(paramIntent);
      }
    } while (i != -6);
    return new ascg(paramIntent);
  }
  
  public static aryv a(Intent paramIntent, QQAppInterface paramQQAppInterface, Activity paramActivity)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asbd
 * JD-Core Version:    0.7.0.1
 */