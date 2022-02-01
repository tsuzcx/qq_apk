import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

class bogx
  extends Handler
{
  private final WeakReference<bogv> a;
  
  public bogx(bogv parambogv)
  {
    this.a = new WeakReference(parambogv);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((this.a == null) || (this.a.get() == null)) {}
    Object localObject;
    do
    {
      return;
      localObject = (bogv)this.a.get();
      localArrayList = ((bogv)localObject).jdField_a_of_type_Bohc.a.selectedPhotoList;
      switch (paramMessage.what)
      {
      default: 
        return;
      case 0: 
        localObject = ((bogv)localObject).jdField_a_of_type_Bogq;
      }
    } while (localObject == null);
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(((bogq)localObject).a);
    paramMessage = paramMessage.getData();
    int i = paramMessage.getInt("ALBUMLIST_POSITION");
    long l = paramMessage.getLong("ALBUMLIST_ITEM_DURATION");
    paramMessage = (LocalMediaInfo)localArrayList.get(i);
    paramMessage.mDuration = l;
    localArrayList.set(i, paramMessage);
    ((bogq)localObject).a(localArrayList);
    ((bogq)localObject).notifyDataSetChanged();
    return;
    ((bogv)this.a.get()).jdField_a_of_type_Bohc.a(paramMessage);
    return;
    ((bogv)localObject).f();
    QLog.e("PhotoListActivity", 2, new Object[] { "onEncodeError = ", Integer.valueOf(((Integer)paramMessage.obj).intValue()) });
    QQToast.a(((bogv)localObject).getActivity(), ((bogv)localObject).getResources().getString(2131694321), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bogx
 * JD-Core Version:    0.7.0.1
 */