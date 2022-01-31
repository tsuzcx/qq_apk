import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class azhg
  extends BroadcastReceiver
{
  azhg(azhf paramazhf) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction() == null) {}
    do
    {
      do
      {
        return;
        paramContext = this.a.jdField_a_of_type_JavaLangString;
        this.a.c();
      } while ((this.a.jdField_a_of_type_Azhh == null) || (paramContext.equals(this.a.jdField_a_of_type_JavaLangString)));
      if (paramIntent.getAction().equals("android.intent.action.MEDIA_UNMOUNTED"))
      {
        this.a.b();
        this.a.jdField_a_of_type_Azhh.a(0, this.a.jdField_a_of_type_JavaLangString);
        return;
      }
    } while (!paramIntent.getAction().equals("android.intent.action.MEDIA_MOUNTED"));
    this.a.jdField_a_of_type_Azhh.a(1, this.a.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azhg
 * JD-Core Version:    0.7.0.1
 */