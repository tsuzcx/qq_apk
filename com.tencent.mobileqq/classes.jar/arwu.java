import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardPhotoOption;
import com.tencent.mobileqq.forward.ForwardShortVideoOption;
import com.tencent.qphone.base.util.QLog;

public class arwu
{
  public static arum a(Intent paramIntent)
  {
    arvo localarvo = null;
    int i = paramIntent.getIntExtra("forward_type", -1);
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardOptionBuilder", 2, "ForwardOptionBuilder forwardType=" + i);
    }
    if (i == 0) {
      localarvo = new arvo(paramIntent);
    }
    do
    {
      return localarvo;
      if (i == 1) {
        return new ForwardPhotoOption(paramIntent);
      }
      if (i == -1) {
        return new asad(paramIntent);
      }
      if (i == -2) {
        return new arwb(paramIntent);
      }
      if (i == -3) {
        return new arzz(paramIntent);
      }
      if (i == 17) {
        return new arzf(paramIntent);
      }
      if (i == 18) {
        return new arvt(paramIntent);
      }
      if ((i == 20) || (i == 24)) {
        return new arxw(paramIntent);
      }
      if (i == 42) {
        return new arxz(paramIntent);
      }
      if (i == 11) {
        return new arys(paramIntent);
      }
      if (i == 15) {
        return new aruz(paramIntent);
      }
      if (i == 2) {
        return new arxu(paramIntent);
      }
      if (i == 12) {
        return new arud(paramIntent);
      }
      if (i == 1001) {
        return new arxa(paramIntent);
      }
      if (i == -4) {
        return new arvw(paramIntent);
      }
      if (i == 13) {
        return new asap(paramIntent);
      }
      if (i == 14) {
        return new arvj(paramIntent);
      }
      if (i == 9) {
        return new arwc(paramIntent);
      }
      if (i == 16) {
        return new arze(paramIntent);
      }
      if (i == 21) {
        return new ForwardShortVideoOption(paramIntent);
      }
      if (i == 22) {
        return new arxr(paramIntent);
      }
      if (i == 10) {
        return new arvc(paramIntent);
      }
      if (i == 23) {
        return new arzs(paramIntent);
      }
      if (i == 25) {
        return new arvu(paramIntent);
      }
      if (i == 27) {
        return new aruk(paramIntent);
      }
      if (i == 38) {
        return new arui(paramIntent);
      }
      if (i == 35) {
        return new arug(paramIntent);
      }
      if (i == 33) {
        return new aruh(paramIntent);
      }
      if (i == 26) {
        return new arue(paramIntent);
      }
      if (i == -5) {
        return new arwe(paramIntent);
      }
      if (i == 28) {
        return new arxt(paramIntent);
      }
      if (i == 29) {
        return new arxs(paramIntent);
      }
      if (i == 32) {
        return new asao(paramIntent);
      }
      if (i == 34) {
        return new aruf(paramIntent);
      }
      if (i == 36) {
        return new asaf(paramIntent);
      }
      if (i == 37) {
        return new arvv(paramIntent);
      }
      if (i == 39) {
        return new arxv(paramIntent);
      }
      if (i == 41) {
        return new arvs(paramIntent);
      }
    } while (i != -6);
    return new arxx(paramIntent);
  }
  
  public static arum a(Intent paramIntent, QQAppInterface paramQQAppInterface, Activity paramActivity)
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
 * Qualified Name:     arwu
 * JD-Core Version:    0.7.0.1
 */