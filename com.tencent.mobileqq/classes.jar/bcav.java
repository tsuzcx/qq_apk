import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView.Adapter;
import com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel;
import com.tencent.mobileqq.troop.homework.entry.ui.SubmitHomeWorkFragment;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONObject;

public class bcav
  extends Handler
{
  WeakReference<SubmitHomeWorkFragment> a;
  
  public bcav(SubmitHomeWorkFragment paramSubmitHomeWorkFragment, Looper paramLooper)
  {
    super(paramLooper);
    this.a = new WeakReference(paramSubmitHomeWorkFragment);
  }
  
  void a(SubmitHomeWorkFragment paramSubmitHomeWorkFragment)
  {
    if ((paramSubmitHomeWorkFragment.jdField_a_of_type_JavaUtilLinkedList == null) || (paramSubmitHomeWorkFragment.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor == null)) {}
    do
    {
      do
      {
        return;
        if (paramSubmitHomeWorkFragment.jdField_a_of_type_JavaUtilLinkedList.isEmpty())
        {
          paramSubmitHomeWorkFragment.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setVisibility(8);
          paramSubmitHomeWorkFragment.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a();
          paramSubmitHomeWorkFragment.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.setHint(paramSubmitHomeWorkFragment.getActivity().getString(2131697922));
          paramSubmitHomeWorkFragment.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.getAdapter().notifyDataSetChanged();
          return;
        }
      } while (paramSubmitHomeWorkFragment.jdField_b_of_type_Boolean);
      paramSubmitHomeWorkFragment.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.c();
      Iterator localIterator = paramSubmitHomeWorkFragment.jdField_a_of_type_JavaUtilLinkedList.iterator();
      while (localIterator.hasNext())
      {
        JSONObject localJSONObject = (JSONObject)localIterator.next();
        if (QLog.isColorLevel()) {
          QLog.d("SubmitHomeWorkFragment", 2, "insert special item: " + localJSONObject.optString("type"));
        }
        paramSubmitHomeWorkFragment.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(bcdz.a(localJSONObject));
      }
      paramSubmitHomeWorkFragment.jdField_b_of_type_Boolean = true;
    } while (paramSubmitHomeWorkFragment.c != null);
    paramSubmitHomeWorkFragment.c = paramSubmitHomeWorkFragment.jdField_a_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a();
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    SubmitHomeWorkFragment localSubmitHomeWorkFragment = (SubmitHomeWorkFragment)this.a.get();
    if ((localSubmitHomeWorkFragment == null) || (!localSubmitHomeWorkFragment.isAdded())) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 3: 
      localSubmitHomeWorkFragment.jdField_a_of_type_Boolean = true;
      localSubmitHomeWorkFragment.jdField_a_of_type_Bhuf.c(false);
      return;
    case 513: 
      a(localSubmitHomeWorkFragment);
      return;
    case 101: 
      localSubmitHomeWorkFragment.jdField_a_of_type_Boolean = false;
      localSubmitHomeWorkFragment.j();
      return;
    }
    int i = (int)localSubmitHomeWorkFragment.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.a();
    if (i < 1000)
    {
      QQToast.a(localSubmitHomeWorkFragment.getActivity(), alud.a(2131715025), 0).a();
      localSubmitHomeWorkFragment.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.b();
      return;
    }
    if (!bdin.d(localSubmitHomeWorkFragment.getActivity()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SubmitHomeWorkFragment", 2, "no network toast");
      }
      QQToast.a(localSubmitHomeWorkFragment.getActivity(), 2131697661, 0).a();
      localSubmitHomeWorkFragment.jdField_a_of_type_Boolean = false;
      localSubmitHomeWorkFragment.j();
      return;
    }
    paramMessage = paramMessage.obj.toString();
    File localFile = new File(paramMessage);
    if (localFile.exists()) {}
    for (long l = localFile.length();; l = 0L)
    {
      paramMessage = new bcdx(paramMessage, null, i / 1000, (int)l, localSubmitHomeWorkFragment.d);
      localSubmitHomeWorkFragment.jdField_b_of_type_ComTencentMobileqqTroopHomeworkXmediaeditorXMediaEditor.a(paramMessage);
      localSubmitHomeWorkFragment.jdField_a_of_type_Boolean = false;
      localSubmitHomeWorkFragment.j();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcav
 * JD-Core Version:    0.7.0.1
 */