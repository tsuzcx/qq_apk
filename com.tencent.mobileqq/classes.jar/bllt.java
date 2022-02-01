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

class bllt
  extends Handler
{
  private final WeakReference<bllr> a;
  
  public bllt(bllr parambllr)
  {
    this.a = new WeakReference(parambllr);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((this.a == null) || (this.a.get() == null)) {}
    Object localObject;
    do
    {
      return;
      localObject = (bllr)this.a.get();
      switch (paramMessage.what)
      {
      default: 
        return;
      case 0: 
        localObject = ((bllr)localObject).jdField_a_of_type_Bllm;
      }
    } while (localObject == null);
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(((bllm)localObject).a);
    paramMessage = paramMessage.getData();
    int i = paramMessage.getInt("ALBUMLIST_POSITION");
    long l = paramMessage.getLong("ALBUMLIST_ITEM_DURATION");
    paramMessage = (LocalMediaInfo)localArrayList.get(i);
    paramMessage.mDuration = l;
    localArrayList.set(i, paramMessage);
    ((bllm)localObject).a(localArrayList);
    ((bllm)localObject).notifyDataSetChanged();
    return;
    ((bllr)this.a.get()).jdField_a_of_type_Blly.a(paramMessage);
    return;
    ((bllr)localObject).h();
    QLog.e("PhotoListActivity", 2, new Object[] { "onEncodeError = ", Integer.valueOf(((Integer)paramMessage.obj).intValue()) });
    QQToast.a(((bllr)localObject).getActivity(), ((bllr)localObject).getResources().getString(2131694435), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bllt
 * JD-Core Version:    0.7.0.1
 */