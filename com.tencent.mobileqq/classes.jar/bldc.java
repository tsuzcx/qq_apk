import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class bldc
  extends BroadcastReceiver
{
  bldc(bldb parambldb) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction() == null) {}
    do
    {
      do
      {
        return;
        paramContext = this.a.jdField_a_of_type_JavaLangString;
        this.a.b();
      } while ((this.a.jdField_a_of_type_Bldd == null) || (paramContext.equals(this.a.jdField_a_of_type_JavaLangString)));
      if (paramIntent.getAction().equals("android.intent.action.MEDIA_UNMOUNTED"))
      {
        this.a.a();
        this.a.jdField_a_of_type_Bldd.a(0, this.a.jdField_a_of_type_JavaLangString);
        return;
      }
    } while (!paramIntent.getAction().equals("android.intent.action.MEDIA_MOUNTED"));
    this.a.jdField_a_of_type_Bldd.a(1, this.a.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bldc
 * JD-Core Version:    0.7.0.1
 */