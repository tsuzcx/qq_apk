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

class bnfp
  extends Handler
{
  private final WeakReference<bnfn> a;
  
  public bnfp(bnfn parambnfn)
  {
    this.a = new WeakReference(parambnfn);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((this.a == null) || (this.a.get() == null)) {}
    Object localObject;
    do
    {
      return;
      localObject = (bnfn)this.a.get();
      localArrayList = ((bnfn)localObject).jdField_a_of_type_Bnfu.a.selectedPhotoList;
      switch (paramMessage.what)
      {
      default: 
        return;
      case 0: 
        localObject = ((bnfn)localObject).jdField_a_of_type_Bnfi;
      }
    } while (localObject == null);
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(((bnfi)localObject).a);
    paramMessage = paramMessage.getData();
    int i = paramMessage.getInt("ALBUMLIST_POSITION");
    long l = paramMessage.getLong("ALBUMLIST_ITEM_DURATION");
    paramMessage = (LocalMediaInfo)localArrayList.get(i);
    paramMessage.mDuration = l;
    localArrayList.set(i, paramMessage);
    ((bnfi)localObject).a(localArrayList);
    ((bnfi)localObject).notifyDataSetChanged();
    return;
    ((bnfn)this.a.get()).jdField_a_of_type_Bnfu.a(paramMessage);
    return;
    ((bnfn)localObject).d();
    QLog.e("PhotoListActivity", 2, new Object[] { "onEncodeError = ", Integer.valueOf(((Integer)paramMessage.obj).intValue()) });
    QQToast.a(((bnfn)localObject).getActivity(), ((bnfn)localObject).getResources().getString(2131694279), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnfp
 * JD-Core Version:    0.7.0.1
 */