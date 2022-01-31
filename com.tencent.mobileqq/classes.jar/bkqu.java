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

class bkqu
  extends Handler
{
  private final WeakReference<bkqs> a;
  
  public bkqu(bkqs parambkqs)
  {
    this.a = new WeakReference(parambkqs);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if ((this.a == null) || (this.a.get() == null)) {}
    Object localObject2;
    Object localObject1;
    do
    {
      do
      {
        return;
        localObject2 = (bkqs)this.a.get();
        localObject1 = aiqy.getInstance().selectedPhotoList;
        switch (paramMessage.what)
        {
        default: 
          return;
        case 0: 
          localObject1 = ((bkqs)localObject2).jdField_a_of_type_Bkqn;
        }
      } while (localObject1 == null);
      localObject2 = new ArrayList();
      ((List)localObject2).addAll(((bkqn)localObject1).a);
      paramMessage = paramMessage.getData();
      int i = paramMessage.getInt("ALBUMLIST_POSITION");
      long l = paramMessage.getLong("ALBUMLIST_ITEM_DURATION");
      paramMessage = (LocalMediaInfo)((List)localObject2).get(i);
      paramMessage.mDuration = l;
      ((List)localObject2).set(i, paramMessage);
      ((bkqn)localObject1).a((List)localObject2);
      ((bkqn)localObject1).notifyDataSetChanged();
      return;
      ((bkqs)this.a.get()).jdField_a_of_type_Bkrb.a(paramMessage);
      return;
      ((bkqs)localObject2).d();
      QLog.e("PhotoListActivity", 2, new Object[] { "onEncodeError = ", Integer.valueOf(((Integer)paramMessage.obj).intValue()) });
      QQToast.a(((bkqs)localObject2).getActivity(), ((bkqs)localObject2).getResources().getString(2131695264), 0).a();
      return;
    } while (!(paramMessage.obj instanceof String));
    String str = (String)paramMessage.obj;
    paramMessage = (Message)localObject1;
    if (localObject1 == null) {
      paramMessage = new ArrayList();
    }
    QLog.d("PhotoListActivity", 2, new Object[] { "MSG_PHOTO_ENCODE_SUCCEED = ", str });
    if (paramMessage.size() < aiqy.getInstance().maxSelectNum)
    {
      paramMessage.add(str);
      ((bkqs)localObject2).h();
    }
    for (;;)
    {
      ((bkqs)localObject2).b(str);
      return;
      QQToast.a(((bkqs)localObject2).getActivity(), String.format(((bkqs)localObject2).getResources().getString(2131695260), new Object[] { Integer.valueOf(aiqy.getInstance().maxSelectNum) }), 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkqu
 * JD-Core Version:    0.7.0.1
 */