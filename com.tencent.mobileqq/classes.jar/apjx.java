import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.forward.ForwardPhotoOption;
import com.tencent.mobileqq.forward.ForwardShortVideoOption;
import com.tencent.qphone.base.util.QLog;

public class apjx
{
  public static aphp a(Intent paramIntent)
  {
    apir localapir = null;
    int i = paramIntent.getIntExtra("forward_type", -1);
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardOptionBuilder", 2, "ForwardOptionBuilder forwardType=" + i);
    }
    if (i == 0) {
      localapir = new apir(paramIntent);
    }
    do
    {
      return localapir;
      if (i == 1) {
        return new ForwardPhotoOption(paramIntent);
      }
      if (i == -1) {
        return new apmy(paramIntent);
      }
      if (i == -2) {
        return new apje(paramIntent);
      }
      if (i == -3) {
        return new apmu(paramIntent);
      }
      if (i == 17) {
        return new apma(paramIntent);
      }
      if (i == 18) {
        return new apiw(paramIntent);
      }
      if ((i == 20) || (i == 24)) {
        return new apkz(paramIntent);
      }
      if (i == 42) {
        return new aplc(paramIntent);
      }
      if (i == 11) {
        return new apln(paramIntent);
      }
      if (i == 15) {
        return new apic(paramIntent);
      }
      if (i == 2) {
        return new apkx(paramIntent);
      }
      if (i == 12) {
        return new aphg(paramIntent);
      }
      if (i == 1001) {
        return new apkd(paramIntent);
      }
      if (i == -4) {
        return new apiz(paramIntent);
      }
      if (i == 13) {
        return new apnk(paramIntent);
      }
      if (i == 14) {
        return new apim(paramIntent);
      }
      if (i == 9) {
        return new apjf(paramIntent);
      }
      if (i == 16) {
        return new aplz(paramIntent);
      }
      if (i == 21) {
        return new ForwardShortVideoOption(paramIntent);
      }
      if (i == 22) {
        return new apku(paramIntent);
      }
      if (i == 10) {
        return new apif(paramIntent);
      }
      if (i == 23) {
        return new apmn(paramIntent);
      }
      if (i == 25) {
        return new apix(paramIntent);
      }
      if (i == 27) {
        return new aphn(paramIntent);
      }
      if (i == 38) {
        return new aphl(paramIntent);
      }
      if (i == 35) {
        return new aphj(paramIntent);
      }
      if (i == 33) {
        return new aphk(paramIntent);
      }
      if (i == 26) {
        return new aphh(paramIntent);
      }
      if (i == -5) {
        return new apjh(paramIntent);
      }
      if (i == 28) {
        return new apkw(paramIntent);
      }
      if (i == 29) {
        return new apkv(paramIntent);
      }
      if (i == 32) {
        return new apnj(paramIntent);
      }
      if (i == 34) {
        return new aphi(paramIntent);
      }
      if (i == 36) {
        return new apna(paramIntent);
      }
      if (i == 37) {
        return new apiy(paramIntent);
      }
      if (i == 39) {
        return new apky(paramIntent);
      }
      if (i == 41) {
        return new apiv(paramIntent);
      }
    } while (i != -6);
    return new apla(paramIntent);
  }
  
  public static aphp a(Intent paramIntent, QQAppInterface paramQQAppInterface, Activity paramActivity)
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
 * Qualified Name:     apjx
 * JD-Core Version:    0.7.0.1
 */