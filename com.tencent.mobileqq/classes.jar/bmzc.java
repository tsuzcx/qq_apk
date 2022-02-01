import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

class bmzc
  extends Handler
{
  private final WeakReference<bmza> a;
  
  public bmzc(bmza parambmza)
  {
    this.a = new WeakReference(parambmza);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((this.a == null) || (this.a.get() == null)) {}
    Object localObject;
    do
    {
      return;
      localObject = (bmza)this.a.get();
      switch (paramMessage.what)
      {
      default: 
        return;
      case 0: 
        localObject = ((bmza)localObject).jdField_a_of_type_Bmyv;
      }
    } while (localObject == null);
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(((bmyv)localObject).a);
    paramMessage = paramMessage.getData();
    int i = paramMessage.getInt("ALBUMLIST_POSITION");
    long l = paramMessage.getLong("ALBUMLIST_ITEM_DURATION");
    paramMessage = (LocalMediaInfo)localArrayList.get(i);
    paramMessage.mDuration = l;
    localArrayList.set(i, paramMessage);
    ((bmyv)localObject).a(localArrayList);
    ((bmyv)localObject).notifyDataSetChanged();
    return;
    ((bmza)this.a.get()).jdField_a_of_type_Bmzh.a(paramMessage);
    return;
    ((bmza)localObject).h();
    QLog.e("PhotoListActivity", 2, new Object[] { "onEncodeError = ", Integer.valueOf(((Integer)paramMessage.obj).intValue()) });
    QQToast.a(((bmza)localObject).getActivity(), ((bmza)localObject).getResources().getString(2131694636), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmzc
 * JD-Core Version:    0.7.0.1
 */