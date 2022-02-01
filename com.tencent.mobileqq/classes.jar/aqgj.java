import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.util.LruCache;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;

class aqgj
  extends BroadcastReceiver
{
  aqgj(aqgi paramaqgi) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (!"com.tencent.qqhead.getheadresp".equals(paramIntent.getAction())) || (paramIntent.getIntExtra("faceType", -1) != this.a.jdField_a_of_type_Int)) {}
    ArrayList localArrayList;
    do
    {
      return;
      paramContext = paramIntent.getStringArrayListExtra("uinList");
      localArrayList = paramIntent.getStringArrayListExtra("headPathList");
    } while ((paramContext == null) || (localArrayList == null));
    int j = paramContext.size();
    if (QLog.isColorLevel()) {
      QLog.d("NonMainAppHeadLoader", 2, "onReceive, uinListSize:" + j + " reqSize:" + this.a.jdField_a_of_type_JavaUtilHashSet.size());
    }
    paramIntent = new ArrayList(this.a.jdField_a_of_type_JavaUtilHashSet.size());
    int i = 0;
    while (i < j)
    {
      String str = (String)paramContext.get(i);
      if (this.a.jdField_a_of_type_JavaUtilHashSet.contains(str))
      {
        this.a.jdField_a_of_type_JavaUtilHashSet.remove(str);
        paramIntent.add(str);
      }
      this.a.jdField_b_of_type_AndroidSupportV4UtilLruCache.put(str, localArrayList.get(i));
      i += 1;
    }
    paramContext = Message.obtain();
    paramContext.obj = paramIntent;
    paramContext.what = 1001;
    this.a.jdField_b_of_type_AndroidOsHandler.sendMessage(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqgj
 * JD-Core Version:    0.7.0.1
 */